package chat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread {

	private Socket socket;
	private String name;
	DataOutputStream out;
	Scanner sc = new Scanner(System.in);

	public ClientSend(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {

		while (true) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				System.out.print("ют╥б : ");
				String msg = sc.nextLine();
				out.writeUTF("["+name+"] : "+msg);

				System.out.println();
			} catch (IOException e) {
			}
		}
	}

}
