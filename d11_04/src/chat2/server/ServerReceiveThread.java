package chat2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReceiveThread extends Thread {

	private Socket socket;

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String ReceiveString;

			while (true) {
				ReceiveString = br.readLine();

				if (ReceiveString == null) {
					System.out.println("������ ���������ϴ�");
					break;
				} else {
					System.out.println("���� : " + ReceiveString);
				}

			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
