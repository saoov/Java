package test.main;

import test.tcp.TCPEchoClient;

public class MainClient {

	public static void main(String[] args) {
		new TCPEchoClient().clientTCP("192.168.20.44", 7979);

	}

}
