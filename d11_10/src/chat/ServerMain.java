package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			ServerSocket serverSocket = new ServerSocket(7979);
			System.out.println("Server Ready....");
			while(true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+" 사용자가 접속했습니다.");
				
				Thread receive = new Thread(new ServerReceive(socket));
				Thread send = new Thread(new ServerSend(socket));
				
				receive.start();
				send.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
