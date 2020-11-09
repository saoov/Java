package prac;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceive extends Thread {

	private Socket socket;
	DataInputStream in;

	public ClientReceive(Socket socket) {
		this.socket = socket;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
			}
		}
	}

}
