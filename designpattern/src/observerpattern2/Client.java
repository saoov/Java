package observerpattern2;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {

		User user = new User();
		
		ChatRoom chatroom = new ChatRoom("채팅방");
		GameRoom gameroom = new GameRoom("게임방");
		DevRoom devroom = new DevRoom("개발방");
		

		user.attach(chatroom);
		user.attach(gameroom);
		user.attach(devroom);
		
		user.notifyObservers("ㅎㅇ");
	}
}
