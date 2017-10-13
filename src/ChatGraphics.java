import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;


public class ChatGraphics extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 800;
	private JPanel chatPanel;
	private JScrollPane scrollPane;
	private JTextArea inputText, outputText;
	private JButton send;
	private Font guiFont;
	private Client client;

	public ChatGraphics() {
		super("Chat Window");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 50, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		intializeComponents();
	}

	void connectClientToSever() {
		String hostName = JOptionPane.showInputDialog(null, "Please input host to connect to");
		String userName = JOptionPane.showInputDialog(null, "Please input a user name");
		client = new Client(userName, hostName, outputText);
		if (!client.isConnected()) {
			new Thread(new StartLocalServer()).start();
			client = new Client(userName, hostName, outputText);
		}
	}

	private void intializeComponents() {
		chatPanel = new JPanel();
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

		outputText = new JTextArea();
		outputText.setEditable(false);
		outputText.setAlignmentX(Component.CENTER_ALIGNMENT);
		outputText.setMinimumSize(new Dimension(600, 250));
		outputText.setBorder(new EmptyBorder(0, 10, 0, 0));
		outputText.setForeground(Color.BLUE);
		outputText.setAutoscrolls(true);
		DefaultCaret caret = (DefaultCaret) outputText.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		scrollPane = new JScrollPane(outputText);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		scrollPane.setMinimumSize(new Dimension(600, 250));
		chatPanel.add(scrollPane);

		inputText = new JTextArea();
		inputText.setMinimumSize(new Dimension(800, 150));
		inputText.setPreferredSize(new Dimension(800, 150));
		inputText.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
		inputText.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
				BorderFactory.createEmptyBorder(5, 10, 0, 0)));
		inputText.requestFocus();
		inputText.setAlignmentX(Component.CENTER_ALIGNMENT);
		chatPanel.add(inputText);

		Action ctrlEnter = new SendInputAction("Send");

		send = new JButton(ctrlEnter);
		send.setMinimumSize(new Dimension(1000, 100));
		send.setPreferredSize(new Dimension(1000, 100));
		send.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		send.setAlignmentX(Component.CENTER_ALIGNMENT);
		chatPanel.add(send);

		InputMap imap = chatPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl ENTER"), "addText");
		ActionMap amap = chatPanel.getActionMap();
		amap.put("addText", ctrlEnter);

		guiFont = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
		outputText.setFont(guiFont);
		inputText.setFont(guiFont);
		send.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

		this.add(chatPanel);
	}

	private void sendMessageToClient(String input) {
		client.newMessage(input);
		inputText.setText("");
	}

	public void addPreviousChat(String chat) {
		outputText.append(chat);
		inputText.requestFocus();
	}

	private class SendInputAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		public SendInputAction(String name) {
			putValue(Action.NAME, name);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			sendMessageToClient(inputText.getText() + "\n");
			inputText.requestFocus();
		}

	}

	private class StartLocalServer implements Runnable {

		public StartLocalServer() {

		}

		@Override
		public void run() {
			new Server();
		}
	}

}
