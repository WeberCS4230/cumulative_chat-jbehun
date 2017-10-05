import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatGraphics extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 800;
	private JPanel chatPanel;
	private JScrollPane scrollPane;
	private JTextArea inputText, outputText;
	private JButton send;

	public ChatGraphics() {
		super("Chat Window");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400, 100, DEFAULT_WIDTH, DEFAULT_HEIGHT);
		intializeComponents();
	}

	private void intializeComponents() {
		chatPanel = new JPanel();
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

		outputText = new JTextArea();
		outputText.setEditable(false);
		outputText.setAlignmentX(Component.CENTER_ALIGNMENT);
		outputText.setMinimumSize(new Dimension(600, 250));
		// outputText.setPreferredSize(new Dimension(1000, 250));
		// outputText.setMaximumSize(new Dimension(1000, 250));

		scrollPane = new JScrollPane(outputText);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		scrollPane.setMinimumSize(new Dimension(600, 250));
		chatPanel.add(scrollPane);

		inputText = new JTextArea();
		inputText.setMinimumSize(new Dimension(800, 150));
		inputText.setPreferredSize(new Dimension(800, 150));
		inputText.setMaximumSize(new Dimension(800, 150));
		inputText.requestFocus();
		inputText.setAlignmentX(Component.CENTER_ALIGNMENT);
		chatPanel.add(inputText);

		Action ctrlEnter = new SendInputAction("Send");

		send = new JButton(ctrlEnter);
		send.setMinimumSize(new Dimension(1000, 100));
		send.setPreferredSize(new Dimension(1000, 100));
		send.setMaximumSize(new Dimension(1000, 100));
		send.addActionListener(new SendButtonListener());
		chatPanel.add(send, Component.CENTER_ALIGNMENT);

		InputMap imap = chatPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl ENTER"), "addText");
		ActionMap amap = chatPanel.getActionMap();
		amap.put("addText", ctrlEnter);
		outputText.setText("Hello");

		this.add(chatPanel);
	}

	private void addInputToOuput() {
		outputText.setText(outputText.getText() + "\n" + inputText.getText());
		inputText.setText("");

	}

	public void addPreviousChat(String chat) {
		outputText.setText(chat);
	}

	private class SendButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			addInputToOuput();
			inputText.requestFocus();
		}

	}

	private class SendInputAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		public SendInputAction(String name) {
			putValue(Action.NAME, name);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			addInputToOuput();

		}

	}

}
