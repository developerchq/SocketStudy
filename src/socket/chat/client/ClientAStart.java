package socket.chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientAStart {

	String ip = "";
	int port ;
	static Socket socket = null;
	
	public ClientAStart(String ip,int port) {
		this.ip = ip;
		this.port=port;
	}
	public static void main(String[] args) {
		
		//�����ҷ������
		Server server = new Server(5000);
		Thread thread2 = new Thread(server);
		thread2.start();
		
		//�����ҷ��ͻ���
		Client client = new Client("10.10.121.43", 3434);
		Thread thread1 = new Thread(client);
		thread1.start();
	}
	
	

}
