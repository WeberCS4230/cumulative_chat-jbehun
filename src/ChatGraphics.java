import java.awt.*;
import javax.swing.*;

public class ChatGraphics extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel chatPanel;
	private JScrollPane scrollPane;
	private JTextArea inputText, outputText;
	private JButton send;

	public ChatGraphics() {
		super("Chat Window");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(250, 250, 400, 500);
		intializeComponents();
	}

	private void intializeComponents() {
		chatPanel = new JPanel();
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));

		outputText = new JTextArea();
		outputText.setEditable(false);
		outputText.setAlignmentX(Component.CENTER_ALIGNMENT);
		outputText.setMinimumSize(new Dimension(800, 250));
		outputText.setPreferredSize(new Dimension(800, 250));
		outputText.setMaximumSize(new Dimension(800, 250));
		scrollPane = new JScrollPane(outputText);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		chatPanel.add(scrollPane);

		inputText = new JTextArea();
		chatPanel.add(inputText, Component.CENTER_ALIGNMENT);
		inputText.setText("GoodBye");

		send = new JButton("Send");
		send.setMinimumSize(new Dimension(1000, 100));
		send.setPreferredSize(new Dimension(1000, 100));
		send.setMaximumSize(new Dimension(1000, 100));
		chatPanel.add(send, Component.CENTER_ALIGNMENT);

		outputText.setText("Hello");

		this.add(chatPanel);
	}
}
