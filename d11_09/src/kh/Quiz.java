package kh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Rec extends Thread {
	Socket socket;
	DataInputStream in;

	public Rec(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		while (true) {
			try {
				in = new DataInputStream(socket.getInputStream());
				System.out.println(in.readUTF());
			} catch (IOException e) {
			}

		}
	}

}

class Send extends Thread {
	Socket socket;
	DataOutputStream out;

	public Send(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				out.writeUTF(sc.nextLine());
			} catch (IOException e) {
			}

		}
	}
}

public class Quiz {

	public static void main(String[] args) {

		String Ip = "192.168.20.123";
		int port = 7788;
		Socket socket;
		try {
			socket = new Socket(Ip, port);
			Thread send = new Thread(new Send(socket));
			Thread Rec = new Thread(new Rec(socket));
			send.start();
			Rec.start();

		} catch (IOException e) {

		}
	}
}
