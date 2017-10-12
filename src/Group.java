import java.util.*;

public class Group implements Comparable<Group> {

	private Student student1, student2;

	public Group(Student s1, Student s2) {
		student1 = s1;
		student2 = s2;
	}

	public void addStudent1ChatMessage(String s) {
		student1.addMessage(s);
	}

	public void addStudent2ChatMessage(String s) {
		student2.addMessage(s);
	}

	public LinkedList<String> getChatLog() {

		LinkedList<String> messages = new LinkedList<String>();
		String[] s1messages = student1.getMessages();
		String[] s2messages = student2.getMessages();

		for (int i = 0; i < s1messages.length; i++) {
			messages.add(student1.toString() + ": " + s1messages[i]);
			messages.add(student2.toString() + ": " + s2messages[i]);
		}

		return messages;
	}

	public Student getStudent1() {
		return student1;
	}

	public Student getStudent2() {
		return student2;
	}

	@Override
	public String toString() {
		return "(" + student1 + ", " + student2 + ")";
	}

	@Override
	public int compareTo(Group g) {
		Group g2 = (Group) g;
		int c = this.student1.getFirstName().compareTo(g2.student1.getFirstName());
		if (c != 0) {
			return c;
		} else {
			c = this.student1.getLastName().compareTo(g2.student1.getLastName());
			if (c != 0) {
				return c;
			}
		}

		return 0;
	}

}
