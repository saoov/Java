package Exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChattingServer {

	public void chattingServer() {

		int port = 8888;

		ServerSocket serverSocket = null;

		DataInputStream dis = null;

		DataOutputStream dos = null;

		try {

			serverSocket = new ServerSocket(port);

			while (true) {
				Socket clientSocket = serverSocket.accept();

				InputStream in = clientSocket.getInputStream();

				OutputStream out = clientSocket.getOutputStream();

				dis = new DataInputStream(in);

				dos = new DataOutputStream(out);

				dos.writeUTF("[���� ���� ����]");

				Date date = new Date();

				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

				String now = sdf.format(date);

				dos.writeUTF("[����ð�] : " + now);

				break;
			}
		} catch (IOException e) {


		} finally {

			try {
				dis.close();

				dos.close();

			} catch (IOException e) {


			}

		}

	}

}