package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerSend extends Thread {

	private Socket socket;
	DataOutputStream out;
	Scanner sc = new Scanner(System.in);

	public ServerSend(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				System.out.print("ют╥б : ");
				out.writeUTF("[Server] : " + sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
