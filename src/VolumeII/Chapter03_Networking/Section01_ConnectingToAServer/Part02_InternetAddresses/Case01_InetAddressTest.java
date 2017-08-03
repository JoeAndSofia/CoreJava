package VolumeII.Chapter03_Networking.Section01_ConnectingToAServer.Part02_InternetAddresses;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import basic.Basic;

public class Case01_InetAddressTest extends Basic{

	public static void main(String[] args){
		try{
			String host = null;
			 host = "www.baidu.com";		//2 addresses
//			 host = "baidu.com";		//4 addresses
//			 host = "developer.google.com";	//6 addresses
//			 host = "google.com";		//1 address
//			 host = "www.google.com";		//1 address
//			 host = "maps.google.com";		//1 address
//			 host = "www.google.com.hk";		//1 address
			test01(host);
			
			pl("************************************************************************************");
			
			test02(new String[]{host});
			
			pl("************************************************************************************");
			
			test02(new String[]{});
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * print Internet Address 
	 * @param host
	 * @throws Exception
	 */
	public static void test01(String host) throws Exception{
		InetAddress address = InetAddress.getByName(host);
		printAddressV01(address);
		pl("******************************************");
		printAddressV02(address);
		pl("******************************************");
		printAddressV03(address);
		pl("******************************************");
		printAddressV04(host);
		pl("******************************************");
		printAddressLocal();
	}
	
	/**
	 * get ip address byte array
	 * @param address
	 */
	public static void printAddressV01(InetAddress address){
		byte[] addressBytes = address.getAddress();
		pl("length: " + addressBytes.length);
		for(byte b : addressBytes){
			pl((b<0?(b+256):b) + "(" + b + ")");
		}
	}

	/**
	 * get ip address
	 * @param address
	 * @throws UnsupportedEncodingException
	 */
	public static void printAddressV02(InetAddress address) throws UnsupportedEncodingException{
		pl(new String(address.getHostAddress()));
	}

	/**
	 * InetAddress print case
	 * @param address
	 */
	public static void printAddressV03(InetAddress address){
		pl(address);
		pl(address.getHostName());
		pl(address.getHostAddress());
	} 
	
	/**
	 * get all Internet Address name by host
	 * @param host
	 * @throws Exception
	 */
	public static void printAddressV04(String host) throws Exception{
		InetAddress[] addressArr = InetAddress.getAllByName(host);
		for(InetAddress address : addressArr){
			printAddressV01(address);
			printAddressV02(address);
			pl("---------------------");
		}
	}
	
	
	public static void printAddressLocal() throws UnknownHostException, UnsupportedEncodingException{
		InetAddress localHostAddress = InetAddress.getLocalHost();
		printAddressV02(localHostAddress);
	}
	
	public static void test02(String[] args) throws UnknownHostException, UnsupportedEncodingException{
		if(args.length > 0){
			for(String host : args){
				InetAddress[] addresses = InetAddress.getAllByName(host);
				for(InetAddress a : addresses){
					printAddressV02(a);
				}	
			}
		}else{
			InetAddress localHostAddress = InetAddress.getLocalHost();
			printAddressV02(localHostAddress);
		}
	}
}