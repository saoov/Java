package test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPEchoServer {
	public void tcpServer(int port) {
		// 서버 소켓 관련 객체
		ServerSocket serverSock = null;
		Socket sock = null;
		InetAddress inetAddr = null;

		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter wr = null;

		try {
			serverSock = new ServerSocket(port);

			while (true) {
				// 클라이언트 접속 대기
				System.out.println("======클라이언트 접속 대기 중" + "(port" + serverSock.getLocalPort() + ")======");
				sock = serverSock.accept();

				// 클라이언트의 접속 요청
				System.out.println("클라이언트(" + sock.getInetAddress().getHostAddress() + ") 접속");

				// 클라이언트와 통신을 위한 stream 생성
				in = sock.getInputStream();
				out = sock.getOutputStream();
				br = new BufferedReader(new InputStreamReader(in));
				wr = new PrintWriter(new OutputStreamWriter(out));
				String msg = null;

				// 클라이언트와 통신
				while ((msg = br.readLine()) != null) {
					System.out.println("\tCLIENT>" + msg);
					wr.println(msg);
					wr.flush();
				}
			}
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			try {
				br.close();
				wr.close();
				in.close();
				out.close();
				sock.close();
				serverSock.close();
				System.out.println("종료");
			} catch (IOException ie) {
				System.out.println(ie);
			}

		}

	}

}
