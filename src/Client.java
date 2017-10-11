import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {

	private Socket s = null;
	private String name;

	public Client(String n) {
		try {
			s = new Socket("localhost", 8090);
			BufferedReader read = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter write = new PrintWriter(s.getOutputStream());
			write.write(n + "\n");
			write.flush();
			String responseString = read.readLine();
			System.out.println(responseString);
			if (responseString.equals("ACK")) {
				System.out.println("Connected");
			}else if(responseString.equals("Decline")){
				System.out.println("Denied");
			}
			else  {
				System.out.println("Connection Failed");
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
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
				new Client("John");


	}

}
