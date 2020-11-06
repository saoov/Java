package programmers;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataStreamTest2 {

	public static void main(String[] args) {

		try(
				DataInputStream dis = new DataInputStream(new FileInputStream("test.txt"));
				){
			int i = dis.readInt();
			boolean b = dis.readBoolean();
			double d = dis.readDouble();
			
			System.out.println(i);
			System.out.println(b);
			System.out.println(d);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
