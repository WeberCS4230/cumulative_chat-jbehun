
public class Student {
	private String firstName, lastName;
	private int score;

	public Student(String first, String last) {
		firstName = first;
		lastName = last;
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
