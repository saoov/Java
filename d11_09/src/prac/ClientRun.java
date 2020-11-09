package prac;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientRun {

	public static void main(String[] args) {

		String Ip = "192.168.20.44";
		int port = 7979;
		Socket socket = null;

		try {
			socket = new Socket(Ip, port);
			System.out.println("서버에 접속되었습니다.");
			Thread rec = new Thread(new ClientReceive(socket));
			Thread send = new Thread(new ClientSend(socket));
		} catch (IOException e) {
		}

	}

}
