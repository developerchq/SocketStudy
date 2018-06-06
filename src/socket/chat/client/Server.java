package socket.chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

	ServerSocket serverSocket;
	Socket socket;
	public Server(int port) {
		try {
			this.serverSocket = new ServerSocket(port);
			System.out.println("���������A,IP��ַ��"+serverSocket.getInetAddress()+"�˿ںţ�"+port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try {
			while(true) {
				socket = serverSocket.accept();
				InputStream input = socket.getInputStream();
				byte[] b = new byte[512];
				
				input.read(b);
				System.out.println(new String(b));
				//���سɹ�
				socket.getOutputStream().write("send message success".getBytes());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		//�����ҷ������
		Server server = new Server(5000);
		Thread thread2 = new Thread(server);
		thread2.start();
	}
}
