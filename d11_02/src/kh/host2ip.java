package kh;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class host2ip {

	public static void main(String[] args) {
		String hostname = "www.naver.com";
		
		try {
			InetAddress address = InetAddress.getByName(hostname);
			System.out.println("IP�ּ� : "+address.getHostAddress());
			System.out.println("ȣ��Ʈ���� : "+address.getHostName());
			System.out.println("����ȣ��Ʈ : "+address.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
