package kh;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		// PID 9100에 해당하는 프로세스가 열려있으면 서버가 안열림
		ServerSocket ss = new ServerSocket(9100);
		try {
			while (true) {
				Socket socket = ss.accept();
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println("ㅎㅎ");
				} finally {
					socket.close();
				}
			}
		} finally {
			ss.close();
		}
	}
}
