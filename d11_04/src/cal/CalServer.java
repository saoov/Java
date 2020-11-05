package cal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class CalServer {

	ServerSocket server;
	Socket socket;
	InputStream in;
	OutputStream out;
	BufferedReader br;
	PrintWriter pw;
	final int port = 7979;

	public CalServer() throws IOException {
		try {
			server = new ServerSocket(port);

			while (true) {
				System.out.println("Cal Server is Ready....");
				socket = server.accept();
				System.out.println("Connected : " + socket.getInetAddress().getHostAddress());

				in = socket.getInputStream();
				br = new BufferedReader(new InputStreamReader(in));
				out = socket.getOutputStream();
				pw = new PrintWriter(new OutputStreamWriter(out));

				String msg;
				while ((msg = br.readLine()) != null) {
					System.out.println("Client >>" + msg);
					int result = 0;
					if (msg.contains("+")) {
						StringTokenizer st = new StringTokenizer(msg, " + ");
						result = Integer.parseInt(st.nextToken());
						result +=Integer.parseInt(st.nextToken());
					} else if (msg.contains("-")) {
						StringTokenizer st = new StringTokenizer(msg, " - ");
						result = Integer.parseInt(st.nextToken());
						result -=Integer.parseInt(st.nextToken());
					} else if (msg.contains("*")) {
						StringTokenizer st = new StringTokenizer(msg, " * ");
						result = Integer.parseInt(st.nextToken());
						result *=Integer.parseInt(st.nextToken());
					} else if (msg.contains("/")) {
						StringTokenizer st = new StringTokenizer(msg, " / ");
						result = Integer.parseInt(st.nextToken());
						result /=Double.parseDouble(st.nextToken());
					} else if (msg.contains("bye")) {
						new IOException();
					}

					pw.println(result);
					pw.flush();
				}
			}

		} catch (IOException e) {
			System.out.println("접속을 종료하였습니다.");
		} finally {
			br.close();
			pw.close();
			socket.close();
			server.close();
		}
	}

	public static void main(String[] args) throws IOException {
		new CalServer();
	}

}
