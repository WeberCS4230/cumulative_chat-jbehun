import java.util.HashSet;
import java.util.Set;

import sun.text.normalizer.RangeValueIterator.Element;

public class StudentChat {

	public static void main(String[] args) {
		
		HashSet<Student> Students = new HashSet<Student>();
		
		addStudent(Students);
		
		
		
		//printing out list of students
		for(Student s: Students)
		{
			System.out.println(s.toString());
		}
		
		
	}

	//method to add students to the class
	private static void addStudent(HashSet<Student> s) {
		s.add(new Student("Justin", "Behunin"));
		s.add(new Student("Kenyon", "Brown"));
		s.add(new Student("Austin", "Forsling"));
		s.add(new Student("Nicholas", "Goldberg"));
		s.add(new Student("Tyler", "Hoyer"));
		s.add(new Student("Steven", "Julien"));
		s.add(new Student("Johnathan", "Mirable"));
		s.add(new Student("Christopher", "Nash"));
		
		
	}
	


}
