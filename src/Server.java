import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	private ServerSocket ss;
	private Set<String> clients = new HashSet<String>();
	private ArrayList<Socket> socketList = new ArrayList<Socket>();

	public Server() {
		try {
			ss = new ServerSocket(8090);
			while (true) {
				Socket s = ss.accept();
				BufferedReader read = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter write = new PrintWriter(s.getOutputStream());
				String user = read.readLine();
				if (clients.add(user)) {
					write.println("ACK\n");
					write.flush();
					socketList.add(s);
					new Thread(new ClientHandler(s, user)).start();
				} else {
					write.println("Decline\n");
					write.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class ClientHandler implements Runnable {

		private BufferedReader input;
		private PrintWriter output;
		private Socket s;
		private String userName;

		public ClientHandler(Socket socket, String user) {
			try {
				s = socket;
				input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				output = new PrintWriter(socket.getOutputStream());
				userName = user;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				while (true) {
					String receivedMessage = userName + ": " + input.readLine() + "\n";
					for(Socket socket : socketList){
					output = new PrintWriter(socket.getOutputStream());	
					output.println(receivedMessage);
					output.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					s.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					s.getOutputStream().close();
				} catch (IOException e) {

				}
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new Server();
	}

}
