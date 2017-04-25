package vII_c03_Networking.s01_ConnectingToAServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	
	public static void main(String[] args) throws IOException{
		try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)){
			InputStream is = s.getInputStream();
			Scanner in = new Scanner(is);
			
			while(in.hasNextLine()){
				String line = in.nextLine();
				System.out.println(line);
			}
		}
	}
}
