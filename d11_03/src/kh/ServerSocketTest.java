package kh;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		// PID 9100�� �ش��ϴ� ���μ����� ���������� ������ �ȿ���
		ServerSocket ss = new ServerSocket(9100);
		try {
			while (true) {
				Socket socket = ss.accept();
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println("����");
				} finally {
					socket.close();
				}
			}
		} finally {
			ss.close();
		}
	}
}
