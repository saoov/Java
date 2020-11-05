package chat2.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {

	public static void main(String[] args) {
		String IP = "192.168.20.44";
		int port = 7979;
		
		try {
			Socket c_socket = new Socket(IP, port);
			System.out.print("����Ǿ����ϴ�. ���̵� �Է��ϼ��� : ");
			ClientReceiveThread rec_Thread = new ClientReceiveThread();
			rec_Thread.setSocket(c_socket);
			
			ClientSendThread send_Thread = new ClientSendThread();
			send_Thread.setSocket(c_socket);
			
			send_Thread.start();
			rec_Thread.start();
			
			
			
		} catch (UnknownHostException e) {
			System.out.println("������ ����Ǿ����ϴ�.");
		} catch (IOException e) {
			System.out.println("ä�ù��� �����ϴ�.");
		}
		
		

	}

}
