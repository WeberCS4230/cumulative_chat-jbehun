import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import javax.swing.JTextArea;

public class Client {

	private Socket s = null;
	private String name;

	public Client(String n, String host, JTextArea chatOutput) {
		try {
			name = n;
			s = new Socket(host, 8090);
			BufferedReader read = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter write = new PrintWriter(s.getOutputStream());
			write.write(name + "\n");
			write.flush();
			String responseString = read.readLine();
			if (responseString.equals("ACK")) {
				chatOutput.setText(chatOutput.getText() + "Connected\n");
			}else if(responseString.equals("Decline")){
				chatOutput.setText(chatOutput.getText() + "User already connected\n");
			}
			else  {
				chatOutput.setText(chatOutput.getText() + "Connection failed\n");
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


	public static void main(String[] args) {
				//new Client("John", "localhost");


	}

}
