import java.net.Socket;
import java.io.*;

public class WriteThread extends Thread {
	
	Socket client;
	
	public WriteThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		try (Socket client = this.client;
		OutputStream out = client.getOutputStream();
		PrintWriter pout = new PrintWriter(out, true);
				
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);) {
		
		String s;
		while (!pout.checkError() && ((s = br.readLine()) != null)) {
			pout.println(s);
		}
	} catch (Exception ex) {
		ex.printStackTrace();
	}
}
}
