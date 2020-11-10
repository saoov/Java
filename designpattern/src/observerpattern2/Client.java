package observerpattern2;

import java.util.ArrayList;
import java.util.List;

public class Client {
	public static void main(String[] args) {

		User user = new User();
		
		ChatRoom chatroom = new ChatRoom("ä�ù�");
		GameRoom gameroom = new GameRoom("���ӹ�");
		DevRoom devroom = new DevRoom("���߹�");
		

		user.attach(chatroom);
		user.attach(gameroom);
		user.attach(devroom);
		
		user.notifyObservers("����");
	}
}
