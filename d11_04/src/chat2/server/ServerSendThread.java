package chat2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSendThread extends Thread {

	private Socket socket;

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			String sendMsg;

			while(true) {
				sendMsg = br.readLine();
				pw.println(sendMsg);
				pw.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	

}
