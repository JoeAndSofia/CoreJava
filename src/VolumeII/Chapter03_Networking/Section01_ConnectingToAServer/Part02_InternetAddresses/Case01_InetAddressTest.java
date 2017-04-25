package VolumeII.Chapter03_Networking.Section01_ConnectingToAServer.Part02_InternetAddresses;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import basic.Basic;

public class Case01_InetAddressTest extends Basic{

	public static void main(String[] args){
		try{
//			String host = "www.baidu.com";		//2 addresses
//			String host = "baidu.com";		//4 addresses
//			String host = "developer.google.com";	//6 addresses
//			String host = "google.com";		//1 address
//			String host = "www.google.com";		//1 address
//			String host = "maps.google.com";		//1 address
//			String host = "www.google.com.hk";		//1 address
//			test01(host);
//			test02(host);
			
			//*******************************************
			
			test03(new String[]{});
			test03(new String[]{"www.baidu.com"});
			
			//*******************************************
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void printAddressV1(InetAddress address) throws UnsupportedEncodingException{
		printAddressV01Impl01(address);
		pl("-----------------");
		printAddressV02Impl02(address);
		pl("----------------------------------");
	}
	
	public static void printAddressV01Impl01(InetAddress address){
		byte[] addressBytes = address.getAddress();
		pl("length: " + addressBytes.length);
		for(byte b : addressBytes){
			pl(b<0?(b+256):b);
		}
	}

	public static void printAddressV02Impl02(InetAddress address) throws UnsupportedEncodingException{
		pl(new String(address.getHostAddress()));
	}
	
	public static void test01(String host) throws Exception{
		InetAddress address = InetAddress.getByName(host);
		printAddressV1(address);
	}
	
	public static void test02(String host) throws Exception{
		InetAddress[] addressArr = InetAddress.getAllByName(host);
		for(InetAddress address : addressArr){
			printAddressV1(address);
		}
	}
	
	//*******************************************
	
	public static void printAddressV2(InetAddress address){
		pl(address);
		pl(address.getHostName());
		pl(address.getHostAddress());
	} 
	
	public static void test03(String[] args) throws UnknownHostException{
		if(args.length > 0){
			for(String host : args){
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for(InetAddress a : addresses){
					printAddressV2(a);
				}	
			}
		}else{
			InetAddress localHostAddress = InetAddress.getLocalHost();
			printAddressV2(localHostAddress);
		}
	}
}