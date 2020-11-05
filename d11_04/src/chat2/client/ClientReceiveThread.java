package chat2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiveThread extends Thread {

	private Socket socket;

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String ReceiveString;

			while (true) {
				
				ReceiveString = br.readLine();

				System.out.println("»ó´ë¹æ : " + ReceiveString);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
