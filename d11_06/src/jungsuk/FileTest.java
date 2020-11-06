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
		
		while((readCount=fis.read(buffer))!=-1) { //buffer의 수 만큼 읽어오고 읽어온 데이터의 수를 반환
			fos.write(buffer,0,readCount); // 반환된 readCount개 만큼 읽어서 출력소스에 쓴다.
		}

		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		

		fis.close();
		fos.close();
	}

}
