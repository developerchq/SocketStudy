package socket.test.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ip = "10.10.121.43";
		int port = 5000;
		try {
			
			//byte[] b=("Helloween"+new Random(100L).nextInt()).getBytes();

			while(true) {
				Socket socket = new Socket(ip,port);
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String text = reader.readLine();
				
				socket.getOutputStream().write(text.getBytes());
				
				//接受返回信息
				InputStream result = socket.getInputStream();
				byte[] bytes = new byte[512];
				result.read(bytes);
				String str = new String(bytes);
				System.out.println(str);
				
				socket.close();
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
