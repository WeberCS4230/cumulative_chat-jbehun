import java.util.*;

public class Student {
	private String firstName, lastName;
	private int score;
	private LinkedHashSet<String> chat;

	public Student(String first, String last) {
		firstName = first;
		lastName = last;
		chat = new LinkedHashSet<String>();
	}

	public void addMessage(String s) {

		chat.add(s);
	}

	public String[] getMessages() {
		String[] messages;
		messages = chat.toArray(new String[chat.size()]);
		return messages;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
