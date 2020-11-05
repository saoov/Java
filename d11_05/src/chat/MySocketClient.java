package chat;

import java.io.IOException;
import java.net.Socket;

// ������ſ� Ŭ���̾�Ʈ �κ�
public class MySocketClient {
	
	public static void main(String[] args) {
		try {
			Socket socket = null;
            		// ���� ������ ����
			socket = new Socket("192.168.20.44", 7979); 
			System.out.println("������ ���� ����!"); // ���� Ȯ�ο�
			
            		// �������� ���� �޼��� �д� Thread
			ListeningThread t1 = new ListeningThread(socket);
			WritingThread t2 = new WritingThread(socket); // ������ �޼��� ������ Thread

			t1.start(); // ListeningThread Start
			t2.start(); // WritingThread Start
            
		} catch (IOException e) {
			e.printStackTrace(); // ����ó��
		}
	}
}