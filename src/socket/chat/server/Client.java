package socket.chat.server;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

	Socket socket;
	String host ="";
	int port;
	public Client(String host,int port) {
		this.host=host;
		this.port=port;
		System.out.println("启动客户端B");
	}
	@Override
	public void run() {
		try {
			while(true) {
				socket = new Socket(host, port);
				//输入
				Scanner keybordscanner = new Scanner(System.in); 
				String input = keybordscanner.nextLine();
				socket.getOutputStream().write(input.getBytes());
				
				//接受
				InputStream reback = socket.getInputStream();
				byte[] b = new byte[512];
				reback.read(b);
				System.out.println(new String(b));
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}
	public static void main(String[] args) {
		//启动我方客户端
		Client client = new Client("10.10.121.43", 5000);
		Thread thread1 = new Thread(client);
		thread1.start();
	}

}
