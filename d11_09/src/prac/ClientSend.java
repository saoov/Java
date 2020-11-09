package prac;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread {

	private Socket socket;
	DataInputStream in;
	DataOutputStream out;
	Scanner sc = new Scanner(System.in);

	public ClientSend(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
		}

	}

	@Override
	public void run() {

		while (true) {
			try {
				System.out.print("메세지를 입력하세요 : ");
				out.writeUTF(sc.nextLine());
			} catch (IOException e) {
			}
		}
	}
}
