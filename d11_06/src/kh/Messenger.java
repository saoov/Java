package kh;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Messenger {
	private MyFrame f;
	private DatagramSocket socket;
	private InetAddress address = null;
	private final int myPort;
	private final int otherPort;

	public Messenger(int myPort, int otherPort) {
		this.myPort = myPort;
		this.otherPort = otherPort;
		try {
			address = InetAddress.getByName("192.168.20.43");
			socket = new DatagramSocket(myPort);
			f = new MyFrame(address, otherPort, socket);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public MyFrame getMyFrame() {
		return f;
	}
}