package kh;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class host2ip {

	public static void main(String[] args) {
		String hostname = "www.naver.com";
		
		try {
			InetAddress address = InetAddress.getByName(hostname);
			System.out.println("IP주소 : "+address.getHostAddress());
			System.out.println("호스트네임 : "+address.getHostName());
			System.out.println("지역호스트 : "+address.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
