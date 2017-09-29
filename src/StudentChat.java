import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import sun.text.normalizer.RangeValueIterator.Element;

public class StudentChat {

	public static void main(String[] args) {
		
		HashSet<Student> Students = new HashSet<Student>();
		addStudent(Students);
		
		TreeSet<Group> Groups = new TreeSet<Group>();
		addStudentToGroups(Groups, Students);
		
		//printing out list of students
		System.out.println("Students\n");
		for(Student s: Students)
		{
			System.out.println(s.toString());
		}
		
		System.out.println("\nGroups\n");
		for(Group g: Groups)
		{
			System.out.println(g.toString());
		}
		
		
	}


	//adding students to groups
	private static void addStudentToGroups(TreeSet<Group> groups, HashSet<Student> students) {
		//using an iterator to iterator over student set
		
		Iterator iter = students.iterator();
		Student s1, s2;
		
		while(iter.hasNext()) {
			s1 = (Student) iter.next();
			if(!iter.hasNext()) {
				break;
			}
			s2 = (Student) iter.next();
			groups.add(new Group(s1,s2));
		}
		
	}



	//method to add students to the class
	private static void addStudent(HashSet<Student> s) {
		s.add(new Student("Kenyon", "Brown"));
		s.add(new Student("Justin", "Behunin"));
		s.add(new Student("Austin", "Forsling"));
		s.add(new Student("Nicholas", "Goldberg"));
		s.add(new Student("Steven", "Julien"));
		s.add(new Student("Johnathan", "Mirable"));
		s.add(new Student("Tyler", "Hoyer"));
		s.add(new Student("Christopher", "Nash"));
		
		//testing set to make sure duplicate not added
		s.add(new Student("Christopher", "Nash"));
		s.add(new Student("Johnathan", "Mirable"));
	}
	


}
