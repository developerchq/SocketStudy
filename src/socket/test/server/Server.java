package socket.test.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	protected final ServerSocket serverSocket;
	protected Socket socket;
	
	public  Server() throws IOException {
		System.out.println("Æô¶¯·þÎñ¶Ë..");
		this.serverSocket = new ServerSocket(3434);
		
	}
	
	public void receive() {
		try {
			Scanner keybordscanner=null;
			while(true) {
				socket = serverSocket.accept();
				InputStream input = socket.getInputStream();
				byte[] b = new byte[512];
				
				input.read(b);
				System.out.println(new String(b));
				
				keybordscanner = new Scanner(System.in); 
				String reback = keybordscanner.nextLine();
				socket.getOutputStream().write(reback.getBytes());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
