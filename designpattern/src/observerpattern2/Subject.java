package observerpattern2;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private List<Observer> observer = new ArrayList<>();

	public void attach(Observer o) {
		observer.add(o);
	}

	public void detach(Observer o) {
		observer.remove(o);
	}

	public void notifyObservers(String msg) {
		for (Observer o : observer) {
			o.receive(msg);
		}
	}

}
