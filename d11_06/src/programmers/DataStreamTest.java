package programmers;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {

	public static void main(String[] args) throws IOException {

		DataOutputStream dos = new DataOutputStream(new FileOutputStream("test.txt"));
		
		
		//test.txt�� ����� ������� Ÿ�� ���缭 �����;���
		dos.writeInt(100);
		dos.writeBoolean(true);
		dos.writeDouble(3.14);
		
		dos.close();
	}

}
