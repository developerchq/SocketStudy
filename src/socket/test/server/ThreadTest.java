package socket.test.server;

import java.io.IOException;

public class ThreadTest extends Thread {

	private Server server;
	public ThreadTest(Server server) {
		this.server = server;
	}
	public void run() {
		server.receive();
	}
	
	public static void main(String[] args) throws IOException {
		ThreadTest thread = new ThreadTest(new Server());
		thread.run();
	}
}
