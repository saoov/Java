package cal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CalClient {
	
	final int port = 7979;
	final String IP = "192.168.20.44";
	Socket socket;
	InputStream in;
	OutputStream out;
	BufferedReader br;
	BufferedReader stdin;
	PrintWriter pw;
	
	public CalClient() {
		try {
			socket = new Socket(IP, port);
			System.out.println("접속 성공");
			
			in = socket.getInputStream();
			out = socket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(in));
			pw = new PrintWriter(new OutputStreamWriter(out));
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String msg;
			boolean isOn = false;
			
			while(!isOn) {
				System.out.print("계산식(빈칸으로 띄어 입력, 예:24 + 42) >> ");
				msg = stdin.readLine();
				pw.println(msg);
				pw.flush();
				if(msg.equalsIgnoreCase("bye")) {
					isOn = true;
					System.out.println("접속을 종료하였습니다.");
					break;
				}
				
				System.out.println("계산 결과 : "+br.readLine());
				
				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new CalClient();
	}
	
	

}
