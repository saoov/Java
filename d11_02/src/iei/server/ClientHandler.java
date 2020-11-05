package iei.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;


public class ClientHandler extends Thread {

	private Socket client;
	private MyServerChat server;
	private BufferedReader br;
	private PrintWriter pw;

	public ClientHandler(Socket client) throws IOException {
		this.client = client;
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		pw = new PrintWriter(client.getOutputStream());
	}

	public ClientHandler(MyServerChat server, Socket client) {
		this.server = server;
		this.client = client;

		try {
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			pw = new PrintWriter(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// �� Ŭ���̾�Ʈ�κ��� �޼��� �о����
		// �о���� �޼����� ����� ��� Ŭ���̾�Ʈ���� ������
		String nickName = null;

		try {
			nickName = br.readLine();
			String sendMessage = "[" + nickName + "] ���� �����ϼ̽��ϴ�.";
			server.displayMsg(sendMessage);
			sendAll(sendMessage);

			// ��ȭ����
			while (true) {
				String message = br.readLine();
				sendMessage = nickName + " : " + message;
				server.displayMsg(sendMessage);
				sendAll(sendMessage);
			} // �ش� Ŭ���̾�Ʈ�� ���������ϸ� Exception �߻���

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			String sendMessage = "[" + nickName + "]���� �����ϼ̽��ϴ�.";
			server.displayMsg(sendMessage);
			sendAll(sendMessage);
		}
	}

	public void sendAll(String sendMessage) {
		// ����� ���ϵ鿡 ���� ��� ��Ʈ�� �����ϰ� �α����� Ŭ���̾�Ʈ ��ο��� �޼��� ���� ó��
		Vector<Socket> clients = server.getClients();
		synchronized (clients) {
			for (int i = 0; i < clients.size(); i++) {
				ClientHandler otherClient = null;
				try {
					otherClient = new ClientHandler(clients.get(i));
					otherClient.pw.println(sendMessage);
					otherClient.pw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						otherClient.br.close();
						otherClient.pw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			}
		}
	}

}
