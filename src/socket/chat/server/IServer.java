package socket.chat.server;

public interface IServer {
	public void send(String ToIP,int ToPort,byte[] content);
	public void receive(String fromIP,int FromPort,byte[] content);
}
