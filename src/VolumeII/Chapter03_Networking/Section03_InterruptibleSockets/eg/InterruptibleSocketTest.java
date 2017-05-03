package VolumeII.Chapter03_Networking.Section03_InterruptibleSockets.eg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import basic.Basic;

public class InterruptibleSocketTest {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new InterruptibleSocketFrame();
				frame.setTitle("InterruptibleSocketTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}


}

class InterruptibleSocketFrame extends JFrame{
	public static final int TEXT_ROWS = 20;
	public static final int TEXT_COLUMNS = 60;

	private Scanner in;
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancelButton;
	private JButton clearButton;
	private JScrollPane messageArea;
	private JTextArea messages;
	private TestServer server;
	private Thread connectThread;
	
	private int rowHeight = 12;

	public InterruptibleSocketFrame(){
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);

		messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		messages.setFont(new Font("Dialog",Font.PLAIN,rowHeight));
		add(messageArea = new JScrollPane(messages));

		interruptibleButton = new JButton("Interruptible");
		blockingButton = new JButton("Blocking");
		northPanel.add(interruptibleButton);
		northPanel.add(blockingButton);

		interruptibleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable() {

					@Override
					public void run() {
						try{
							connectInterruptibly();
						}catch(IOException e){
							messages.append("\nInterruptibleSocketTest.connectInterruptibly: " + e);
							textAreaDown();
						}
					}
				});
				connectThread.start();
			}
		});

		blockingButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable() {

					@Override
					public void run() {
						try{
							connectBlocking();
						}catch(IOException e){
							messages.append("\nInterruptibleSocketTest.connectBlocking: " + e);
							textAreaDown();
						}
					}
				});
				connectThread.start();
			}
		});

		cancelButton = new JButton("Cancel");
		cancelButton.setEnabled(false);
		northPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				connectThread.interrupt();
				cancelButton.setEnabled(false);
			}
		});
		
		clearButton = new JButton("Clear");
		northPanel.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messages.setText("");
			}
		});
		
		server = new TestServer();
		new Thread(server).start();
		pack();
	}
	
	/**
	 * Connects to the test server, using interruptible I/O
	 */
	public void connectInterruptibly() throws IOException{
		messages.append("interruptible:\n");
		textAreaDown();
		try(SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost",8189))){
			in = new Scanner(channel);
			while(!Thread.currentThread().isInterrupted()){
				
				if(in.hasNextLine()){
					messages.append("Reading-Interruptibly ");
					String line = in.nextLine();
					messages.append(line);
					messages.append("\n");
					textAreaDown();
				}
			}
		}finally{
			EventQueue.invokeLater(new Runnable() {

				@Override
				public void run() {
					messages.append("Channel closed\n");
					textAreaDown();
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
	}

	/**
	 * Connects to the test server, using blocking I/O
	 */
	public void connectBlocking() throws IOException{
		messages.append("Blocking:\n");
		textAreaDown();
		try(Socket sock = new Socket("localhost", 8189)){
			in = new Scanner(sock.getInputStream());
			while(!Thread.currentThread().isInterrupted()){
				
				if(in.hasNextLine()){
					messages.append("Reading-Blocking ");
					String line = in.nextLine();
					messages.append(line);
					messages.append("\n");
					textAreaDown();
				}
			}
		}finally{
			EventQueue.invokeLater(new Runnable() {
				
				@Override
				public void run() {
					messages.append("Socket closed\n");
					textAreaDown();
					interruptibleButton.setEnabled(true);
					blockingButton.setEnabled(true);
				}
			});
		}
	}
	
	public void textAreaDown(){
//		Basic.pl(messages.getFont());
		messageArea.getViewport().setViewPosition(new Point(0,(messages.getLineCount()+1)*rowHeight));
	}
	
	/**
	 * A multithreaded server that listens to port 8189 and sends numbers to the client, simulating a hanging server after 10 numbers.
	 */
	class TestServer implements Runnable{

		@Override
		public void run() {
			try{
				ServerSocket s = new ServerSocket(8189);
				while(true){
					Socket incoming = s.accept();
					Runnable r = new TestServerHandler(incoming);
					Thread t = new Thread(r);
					t.start();
				}
			}catch(IOException e){
				messages.append("\nTestServer.run: " + e);
				textAreaDown();
			}
		}
	}
	
	/**
	 * This class handles the client input for one server socket connection.
	 */
	class TestServerHandler implements Runnable{
		private Socket incoming;
		private int counter;
		
		public TestServerHandler(Socket i){
			incoming = i;
		}

		@Override
		public void run() {
			try{
				try{
					OutputStream outStream = incoming.getOutputStream();
					PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
					while(counter < 100){
						counter++;
						if(counter <= 10) out.println(counter);
						Thread.sleep(100);
					}
				}finally{
					incoming.close();
					messages.append("Closing server\n");
					textAreaDown();
				}
			}catch(Exception e){
				messages.append("\nTestServerHandler.run: " + e);
				textAreaDown();
			}
		}
		
	}
}

