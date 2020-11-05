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
			System.out.print("연결되었습니다. 아이디를 입력하세요 : ");
			ClientReceiveThread rec_Thread = new ClientReceiveThread();
			rec_Thread.setSocket(c_socket);
			
			ClientSendThread send_Thread = new ClientSendThread();
			send_Thread.setSocket(c_socket);
			
			send_Thread.start();
			rec_Thread.start();
			
			
			
		} catch (UnknownHostException e) {
			System.out.println("서버가 종료되었습니다.");
		} catch (IOException e) {
			System.out.println("채팅방이 없습니다.");
		}
		
		

	}

}
