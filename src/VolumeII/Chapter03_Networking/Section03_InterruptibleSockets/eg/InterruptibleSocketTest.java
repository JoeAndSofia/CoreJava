package VolumeII.Chapter03_Networking.Section03_InterruptibleSockets.eg;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class InterruptibleSocketTest {
	public static void main(String[] args){
		
	}
	
	
}

class InterruptibleSocketFrame extends JFrame{
	public static final int TEXT_ROWS = 20;
	public static final int TEXT_COLUMNS = 60;
	
	private Scanner in;
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancelButton;
	private JTextArea messages;
	private TestServer server;
	private Thread connectThread;
	
	
}

class TestServer implements Runnable{

	@Override
	public void run() {
		
		
	}
	
}