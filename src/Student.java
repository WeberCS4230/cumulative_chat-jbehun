import java.util.LinkedHashSet;

public class Student {
	private String firstName, lastName;
	private int score;
	private LinkedHashSet<String> chat; //ordered without duplicates

	public Student(String first, String last) {
		firstName = first;
		lastName = last;
		chat = new LinkedHashSet<String>();
	}

	//add a new message to the hashset
	public void addMessage(String s) {
		
		chat.add(s);
	}
	
	//returns the values in the set to an array.
	public String[] getMessage() {
		String[] messages;
		messages = chat.toArray(new String[chat.size()]);
		return messages;
	}
	
	//default get set methods.
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
		return firstName +" " + lastName;
	}
	
	
	
	
}
