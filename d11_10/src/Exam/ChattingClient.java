package Exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ChattingClient {

	public void chattingClient() {

		String serverIp = "127.0.0.1";

		int serverPort = 8888;

		Socket socket = null;

		DataInputStream dis = null;

		DataOutputStream dos = null;

		try {

			socket = new Socket(serverIp, serverPort);

			InputStream in = socket.getInputStream();

			OutputStream out = socket.getOutputStream();

			dis = new DataInputStream(in);

			dos = new DataOutputStream(out);
			while (dis != null) {
				String serverMsg = dis.readUTF();

				System.out.println(serverMsg);
			}
		} catch (IOException e) {


		} finally {

			try {

				dis.close();

				dos.close();
				socket.close();

			} catch (IOException e) {


			}

		}

	}

}