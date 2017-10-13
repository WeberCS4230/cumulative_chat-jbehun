import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Client {

	private Socket s = null;
	private String name;
	private JTextArea outputText;
	private Boolean connected = false;

	public Client(String n, String host, JTextArea chatOutput) {
		try {
			name = n;
			outputText = chatOutput;
			DefaultCaret caret = (DefaultCaret) outputText.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			s = new Socket(host, 8090);
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter writer = new PrintWriter(s.getOutputStream());
			writer.write(name + "\n");
			writer.flush();
			String responseString = reader.readLine();
			if (responseString.equals("ACK")) {
				chatOutput.append("Connected\n");
				connected = true;
				new Thread(new InputHander(reader)).start();
			} else if (responseString.equals("Decline")) {
				chatOutput.append("User already connected\n");
				close();
			}
		} catch (IOException e) {
			chatOutput.append("Unable to connect to server\n");
		}
	}

	public Boolean isConnected() {
		return connected;
	}

	public void close() {
		try {
			s.getInputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			s.getOutputStream().close();
		} catch (IOException e) {
			// printing previous stacktraces closing the inputstream closed the output
			// stream
		}
		try {
			s.close();
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
				close();
			}
		}
	}
}
