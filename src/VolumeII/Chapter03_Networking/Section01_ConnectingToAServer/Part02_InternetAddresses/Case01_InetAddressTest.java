package VolumeII.Chapter03_Networking.Section01_ConnectingToAServer.Part02_InternetAddresses;

import java.net.InetAddress;
import java.net.UnknownHostException;

import basic.Basic;

public class Case01_InetAddressTest extends Basic{

	public static void main(String[] args){
		try{
			String host = "";
			test01(host);
		}catch(Exception e){
			
		}
	}
	
	public static void test01(String host) throws UnknownHostException{
		InetAddress address = InetAddress.getByName(host);
		
	}
}