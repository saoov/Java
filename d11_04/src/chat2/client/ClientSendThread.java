package chat2.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSendThread extends Thread {

	private Socket socket;

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			String sendMsg;
			String name;
			boolean identify = false;
			
			while(true) {
				if(!identify) {
					name = br.readLine();
					identify = true;
					pw.println(name+"¥‘¿Ã ¡¢º”«œºÃΩ¿¥œ¥Ÿ.");
					continue;
				}
				
				sendMsg = br.readLine();
				
				if(sendMsg.equals("exit")) {
					break;
				}
				pw.println(sendMsg);
				pw.flush();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	

}
