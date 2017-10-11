import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;

public class Server {

	private ServerSocket ss;
	private Set<String> clients = new HashSet<String>();

	public Server() {
		try {
			ss = new ServerSocket(8090);
			while (true) {
				Socket s = ss.accept();
				BufferedReader read = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter write = new PrintWriter(s.getOutputStream());
				if(clients.add(read.readLine())) {
					write.println("ACK\n");
					write.flush();
				}else {
					write.println("Decline\n");
					write.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}
