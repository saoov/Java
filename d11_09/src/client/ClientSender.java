package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender extends Thread {
	Socket socket;
	DataOutputStream out;
	String name;

	public ClientSender(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
		try {
			this.out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		if (out != null) {
			try {
				out.writeUTF(name);
				while (out != null) {
					System.out.print("대화 입력 : ");
					out.writeUTF("[" + name + "] : " + sc.nextLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}