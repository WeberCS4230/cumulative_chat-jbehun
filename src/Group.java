import java.util.LinkedList;

public class Group implements Comparable{

	private Student student1, student2;
	
	public Group(Student s1, Student s2)
	{
		student1 = s1;
		student2 = s2;
	}
	
	public void addChatMessages1(String s) {
		student1.addMessage(s);
	}
	
	public void addChatMessages2(String s) {
		student2.addMessage(s);
	}
	
	//adding the messages for the group to a list for output
	public LinkedList<String> getChatLog(){
		
		LinkedList<String> messages = new LinkedList<String>();
		String[] s1messages = student1.getMessage();
		String[] s2messages = student2.getMessage();
		
		for(int i = 0; i < s1messages.length; i++) {
			messages.add(student1.toString()+ ": " + s1messages[i]);
			messages.add(student2.toString()+ ": " + s2messages[i]);
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
	public int compareTo(Object g) {
		Group g2 = (Group)g;
		int c = this.student1.getFirstName().compareTo(g2.student1.getFirstName());
		if (c != 0) {
			return c;
		}else {
			c = this.student1.getLastName().compareTo(g2.student1.getLastName());
			if (c != 0) {
				return c;
			}
		}
	
		return 0;
	}
	
}
