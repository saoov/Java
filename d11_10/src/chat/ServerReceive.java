package chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerReceive extends Thread {
	private Socket socket;
	private DataInputStream in;

	public ServerReceive(Socket socket) {
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
