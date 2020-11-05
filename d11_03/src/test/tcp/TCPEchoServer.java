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
		// ���� ���� ���� ��ü
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
				// Ŭ���̾�Ʈ ���� ���
				System.out.println("======Ŭ���̾�Ʈ ���� ��� ��" + "(port" + serverSock.getLocalPort() + ")======");
				sock = serverSock.accept();

				// Ŭ���̾�Ʈ�� ���� ��û
				System.out.println("Ŭ���̾�Ʈ(" + sock.getInetAddress().getHostAddress() + ") ����");

				// Ŭ���̾�Ʈ�� ����� ���� stream ����
				in = sock.getInputStream();
				out = sock.getOutputStream();
				br = new BufferedReader(new InputStreamReader(in));
				wr = new PrintWriter(new OutputStreamWriter(out));
				String msg = null;

				// Ŭ���̾�Ʈ�� ���
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
				System.out.println("����");
			} catch (IOException ie) {
				System.out.println(ie);
			}

		}

	}

}
