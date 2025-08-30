import java.io.IOException;
import java.net.Socket;

public class Chat {
	
	Socket client;
	
	public Chat(Socket client) {
		this.client = client;
	}
	
	public void communicate() throws IOException {
		
		try (Socket client = this.client;) {
			
			ReadThread read = new ReadThread(client);
			WriteThread write = new WriteThread(client);
			read.start();
			write.start();
			read.join();
			write.join();
			
	} catch (InterruptedException ex) {
		ex.printStackTrace();
	}
	}
}