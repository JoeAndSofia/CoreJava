package VolumeII.Chapter03_Networking.Section02_ImplementingServers.Part01_ServingMultipleClients;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import basic.Basic;

public class ThreadEchoServer extends Basic{
	
	public static void main(String[] args){
		try{
			threadEcho(8189);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void threadEcho(int port) throws IOException{
		//establish server socket
		try{
			int i = 1;
			ServerSocket s = new ServerSocket(port);
			while(true){
				Socket incoming = s.accept();
				pl("Spawning " + i);
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
				pl(i++);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class ThreadedEchoHandler extends Basic implements Runnable{

	private Socket incoming;
	
	public ThreadedEchoHandler(Socket i){
		incoming = i;
	}
	
	@Override
	public void run() {
		try{
			try{
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
				
				out.println("Hello! Enter BYE to exit.");
				//echo client input
				boolean done = false;
				while(!done && in.hasNextLine()){
					String line = in.nextLine();
					out.println("Echo: " + line);
					if(line.trim().equalsIgnoreCase("bye"))done = true;
				}
			}finally{
				incoming.close();
				pl("server thread done");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
