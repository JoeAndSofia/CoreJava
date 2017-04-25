package vII_c03_Networking.s01_ConnectingToAServer.p01_SocketTimeouts;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import basic.Basic;

public class SocketTimeoutsTest extends Basic{
	
	public static int timeout = 10000;
	
	public static void main(String[] args){
		try{
			test02("baidu.com",0);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void test01()throws IOException, SocketException{
		Socket s = new Socket();
		s.setSoTimeout(timeout);
		
		try{
			InputStream is = s.getInputStream();	
		}catch(IOException e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void test02(String host, int port) throws Exception{
		int i=0;
		pl(i++);
		Socket s = new Socket();
		pl(i++);
		s.connect(new InetSocketAddress(host, port), timeout);
		pl(i++);
		InputStream is = s.getInputStream();
		pl(i++);
		Scanner in = new Scanner(is);
		pl(i++);
		while(in.hasNextLine()){
			String line = in.nextLine();
			pl(line);
			pl(line.length());
		}
		s.close();
		pl(i++);
	}
	
}
