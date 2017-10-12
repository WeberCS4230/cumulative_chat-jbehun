import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import javax.swing.JTextArea;

public class Client {

	private Socket s = null;
	private String name;
	private JTextArea outputText;

	public Client(String n, String host, JTextArea chatOutput) {
		try {
			name = n;
			outputText = chatOutput;
			s = new Socket(host, 8090);
			BufferedReader read = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter write = new PrintWriter(s.getOutputStream());
			write.write(name + "\n");
			write.flush();
			String responseString = read.readLine();
			if (responseString.equals("ACK")) {
				chatOutput.setText(chatOutput.getText() + "Connected\n");
				new Thread(new Handler(read)).start();
			} else if (responseString.equals("Decline")) {
				chatOutput.setText(chatOutput.getText() + "User already connected\n");
			} else {
				chatOutput.setText(chatOutput.getText() + "Connection failed\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class Handler implements Runnable {

		private BufferedReader input;

		public Handler(BufferedReader inputStream) {
			input = inputStream;
		}

		@Override
		public void run() {
			try {
				while (true) {
					outputText.setText(outputText.getText() + input.readLine());
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
		// new Client("John", "localhost");

	}

}
