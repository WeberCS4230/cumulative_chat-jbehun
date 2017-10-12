import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {

	private Socket s = null;
	private String name;
	private JTextArea outputText;

	public Client(String n, String host, JTextArea chatOutput) {
		try {
			name = n;
			outputText = chatOutput;
			s = new Socket(host, 8090);
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter writer = new PrintWriter(s.getOutputStream());
			writer.write(name + "\n");
			writer.flush();
			String responseString = reader.readLine();
			if (responseString.equals("ACK")) {
				chatOutput.setText(chatOutput.getText() + "Connected\n");
				new Thread(new InputHander(reader)).start();
			} else if (responseString.equals("Decline")) {
				chatOutput.setText(chatOutput.getText() + "User already connected\n");
			} else {
				chatOutput.setText(chatOutput.getText() + "Connection failed\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void newMessage(String message) {
		try {
			PrintWriter writer = new PrintWriter(s.getOutputStream());
			writer.write(message);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private class InputHander implements Runnable {

		private BufferedReader input;

		public InputHander(BufferedReader inputStream) {
			input = inputStream;
		}

		@Override
		public void run() {
			try {
				while (true) {
					outputText.append(input.readLine() + "\n");
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
}
