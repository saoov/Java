package chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		String IP = "192.168.20.44";
		int port = 7979;
		Scanner sc = new Scanner(System.in);
		System.out.print("insert id : ");
		String name = sc.nextLine();

		Socket socket;
		try {
			socket = new Socket(IP, port);
			Thread receive = new Thread(new ClientReceive(socket));
			Thread send = new Thread(new ClientSend(socket, name));
			receive.start();
			send.start();
		} catch (IOException e) {
		}

	}

}
