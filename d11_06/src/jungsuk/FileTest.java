package jungsuk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(".\\src\\jungsuk\\FileTest.java");
		FileOutputStream fos = new FileOutputStream("test.txt");
		
		int readCount = -1;
		byte[] buffer = new byte[512];
		
		while((readCount=fis.read(buffer))!=-1) { //buffer�� �� ��ŭ �о���� �о�� �������� ���� ��ȯ
			fos.write(buffer,0,readCount); // ��ȯ�� readCount�� ��ŭ �о ��¼ҽ��� ����.
		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		

		fis.close();
		fos.close();
	}

}
