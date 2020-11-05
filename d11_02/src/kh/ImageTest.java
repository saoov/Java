package kh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class ImageTest {

	public static void main(String[] args) {
		List<Byte> list = new ArrayList<>();
		try {
			URL site = new URL("http://www.oracle.com/us/hp07-bg121314-openworld-2x-2280475.jpg");
			URLConnection url = site.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(url.getInputStream()), 2048);
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\user1\\oracle.jpg"), 2048);

			int data;
			while ((data = br.read()) != -1) {
				list.add((byte) data);
			}

			for (byte b : list) {
				bw.write(b);
			}

			br.close();
			bw.close();

		} catch (IOException e) {
		}
	}

}
