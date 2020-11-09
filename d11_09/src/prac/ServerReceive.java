package prac;

import java.io.DataInputStream;
import java.net.Socket;

public class ServerReceive extends Thread {

	Socket socket;
	DataInputStream in;

	public ServerReceive(Socket socket) {
		this.socket = socket;
	}

}
