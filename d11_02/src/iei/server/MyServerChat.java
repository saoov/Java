package iei.server;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import net.multi.chatt.server.User;

public class MyServerChat {
	Scanner sc = new Scanner(System.in);
	private HashMap<String, User> users; // ȸ�� ���� ����
	private Vector<Socket> clients; // �α����� Ŭ���̾�Ʈ ���ϵ� �����
	
	public MyServerChat()
	{
		ServerSocket chatServerSocket = null;
		int listenPort = 7979; //TCP port
		Socket clientSocket = null;
		OutputStream out = null;
		DataOutputStream dos = null;
		InputStream in = null;
		DataInputStream dis = null;
		String sendMsg = null;
		String recvMsg = null;
		try {
			System.out.println(clock() + "ä�� ������ ���� ���Դϴ�....");
			Thread.sleep(1000);
			chatServerSocket = new ServerSocket(listenPort);
			System.out.println(clock() + "ä�� ������ �����Ͽ����ϴ�");
			Thread.sleep(1000);
			System.out.println(clock() + "Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�");
			clientSocket = chatServerSocket.accept();
			clients.addElement(clientSocket);
			new ClientHandler(new MyServerChat(), clientSocket).start();
			System.out.println(clock() + clientSocket.getInetAddress() + " Ŭ���̾�Ʈ�� �����Ͽ����ϴ�");
			out = clientSocket.getOutputStream();
			dos = new DataOutputStream(out);
			in = clientSocket.getInputStream();
			dis = new DataInputStream(in);
			System.out.println(clock() + "ä���� ���۵Ǿ����ϴ�");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(true)
		{
			try {
				System.out.print("����(��) : ");
				sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
				if(sendMsg.equals("exit"))break; //���� exit �Է½� ���� (������� ������ ����)
				recvMsg = dis.readUTF();
				if(recvMsg.equals("exit")) {
					System.out.println("Ŭ���̾�Ʈ(���) : ������ ä���� �����Ͽ����ϴ�");
					break; //��밡 exit �Է½� ����
				}
				System.out.println("Ŭ���̾�Ʈ(���) : " + recvMsg);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}	
		}
		System.out.println(clock() + "ä�ü����� �����մϴ�");
		try {
			dis.close(); // �޴� ����Ʈ ��Ʈ�� ����
			dos.close(); // ������ ����Ʈ ��Ʈ�� ����
			chatServerSocket.close(); //���� ���� ����
			//Ŭ���̾�Ʈ���� ���� ������ Ŭ���̾�Ʈ�� ������ �ڵ����� ����
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void displayMsg(String clientMessage) {
		System.out.println(clientMessage);
	}
	
	public Map<String, User> getUsers() {
		return users;
	}

	public Vector<Socket> getClients() {
		return clients;
	}
	String clock()
	{
		Date dtime = new Date(); //�ð���ü ����
		String time = new SimpleDateFormat("[HH:mm:ss]").format(dtime); //�ð� ���� �����Ͽ� ���ڿ��� ����
		return time; // ���˵� ���ڿ� ����
	}
}
