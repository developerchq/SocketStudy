package socket.test.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	protected final ServerSocket serverSocket;
	protected Socket socket;
	
	public  Server() throws IOException {
		System.out.println("Æô¶¯·þÎñ¶Ë..");
		this.serverSocket = new ServerSocket(3434);
		
	}
	
	
	public void receive() {
		try {
			while(true) {
				socket = serverSocket.accept();
				InputStream input = socket.getInputStream();
				byte[] b = new byte[512];
				input.read(b);
				String str = new String(b);
				System.out.println(str);
				
				byte[] reback = str.getBytes();
				socket.getOutputStream().write(reback);

			}
					} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
