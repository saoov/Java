package prac;

import java.io.DataOutputStream;
import java.net.Socket;

public class ServerSend extends Thread{

	Socket socket;
	DataOutputStream out;

	public ServerSend(Socket socket) {
		this.socket = socket;
	}

}
