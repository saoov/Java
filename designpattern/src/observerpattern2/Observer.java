package observerpattern2;

public class Observer {
	public String roomName;

	public Observer(String roomName) {
		this.roomName = roomName;
	}

	public void receive(String msg) {
		System.out.println(roomName + " : " + msg);
	}
}

class ChatRoom extends Observer {

	public ChatRoom(String roomName) {
		super(roomName);
	}

}

class GameRoom extends Observer {

	public GameRoom(String roomName) {
		super(roomName);
	}

}

class DevRoom extends Observer {

	public DevRoom(String roomName) {
		super(roomName);
	}

}