package chat;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WritingThread extends Thread { // ������ �޼��� ������ Thread
	Socket socket = null;
	Scanner scanner = new Scanner(System.in); // ä�ÿ� Scanner

	public WritingThread(Socket socket) { // ������
		// �޾ƿ� Socket Parameter�� �ش� Ŭ���� Socket�� �ֱ�
		this.socket = socket;
	}

	public void run() {
		try {
			// OutputStream - Ŭ���̾�Ʈ���� Server�� �޼��� �߼�
			// socket�� OutputStream ������ OutputStream out�� ���� ��
			OutputStream out = socket.getOutputStream();
			// PrintWriter�� �� OutputStream�� ��� ���
			PrintWriter writer = new PrintWriter(out, true);

			while (true) { // ���ѹݺ�
				writer.println(scanner.nextLine()); // �Է��� �޼��� �߼�
			}

		} catch (Exception e) {
			e.printStackTrace(); // ����ó��
		}

	}

}