package VolumeII.Chapter03_Networking.Section01_ConnectingToAServer.eg;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	
	public static void main(String[] args){
		try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)){
			InputStream is = s.getInputStream();
			Scanner in = new Scanner(is);
			
			while(in.hasNextLine()){
				String line = in.nextLine();
				System.out.println(line);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
