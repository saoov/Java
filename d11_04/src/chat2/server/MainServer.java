package chat2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServer {
	static ArrayList<Socket> list = new ArrayList<>();
	static Socket c_socket = null;

	public MainServer(Socket socket) {
		this.c_socket = socket; //���� socket �Ҵ�
		list.add(socket); //������ list�� �߰�
	}

	public static void main(String[] args) {

		try {
			ServerSocket s_socket = new ServerSocket(7979);
			System.out.println("Server is ready");
			while (true) {
				c_socket = s_socket.accept();
				System.out.println(c_socket.getInetAddress().getHostAddress() + " ����");

				ServerReceiveThread rec_Thread = new ServerReceiveThread();
				rec_Thread.setSocket(c_socket);

				ServerSendThread send_Thread = new ServerSendThread();
				send_Thread.setSocket(c_socket);

				rec_Thread.start();
				send_Thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
