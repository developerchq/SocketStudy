package socket.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientBStart {

	String ip = "";
	int port ;
	static Socket socket = null;
	
	public ClientBStart(String ip,int port) {
		this.ip = ip;
		this.port=port;
	}
	public static void main(String[] args) {
		
		//启动我方服务端
		Server server = new Server(3434);
		Thread thread2 = new Thread(server);
		thread2.start();
		
		//启动我方客户端
		Client client = new Client("10.10.121.43", 5000);
		Thread thread1 = new Thread(client);
		thread1.start();
	}
	
	

}
