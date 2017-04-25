package VolumeII.Chapter03_Networking.Section02_ImplementingServers.eg;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import basic.Basic;

public class EchoServer extends Basic{
	
	public static void main(String[] args){
		try{
			echo();	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void echo() throws IOException{
		//establish server socket
		try(ServerSocket s = new ServerSocket(8189)){
			
			//wait for client connection
			try(Socket incoming = s.accept()){
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
				
				try(Scanner in = new Scanner(inStream)){
					PrintWriter out = new PrintWriter(outStream, true /*autoFlush*/);
					
					out.println("Hello! Enter BYE to exit.");
					
					//echo client input
					boolean done = false;
					while(!done && in.hasNextLine()){
						String line = in.nextLine();
						out.println("Echo: " + line);
						pl(line);
						if(line.trim().equalsIgnoreCase("BYE")){
							pl("server shut done");
							done = true;
						}
					}
				}
			}
		}
	}
}
