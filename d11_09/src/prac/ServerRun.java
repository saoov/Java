package prac;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRun {

	public void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;

		while (true) {
			try {
				System.out.println("Server is Ready");
				socket = serverSocket.accept();
				System.out.println("사용자가 접속했습니다.");
				Thread rec = new Thread(new ServerReceive(socket));
				Thread send = new Thread(new ServerSend(socket));
			} catch (IOException e) {
			}

		}

	}

}
