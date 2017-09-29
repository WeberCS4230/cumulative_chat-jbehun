import java.util.Comparator;

public class Group implements Comparable{

	private Student student1, student2;
	
	public Group(Student s1, Student s2)
	{
		student1 = s1;
		student2 = s2;
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
