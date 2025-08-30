import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread{

	Socket client;
	
	public ReadThread(Socket client) {
		this.client = client;
	}
	
	public void run() {
		try (Socket client = this.client; InputStream in = client.getInputStream();
		BufferedReader pin = new BufferedReader(new InputStreamReader(in));) {
			
		String s;
		while ((s = pin.readLine()) != null) {
			System.out.println(String.format("%s:%d > %s ",client.getInetAddress(),client.getPort(),s));
		}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
		
}
