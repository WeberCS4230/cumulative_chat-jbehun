import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import sun.text.normalizer.RangeValueIterator.Element;

public class StudentChat {

	public static void main(String[] args) {
		
		HashSet<Student> Students = new HashSet<Student>();
		addStudent(Students);
		
		TreeSet<Group> Groups = new TreeSet<Group>(); //using treeset to order the groups
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
		
		//getting groups in an array to add chat messages and then display the messages.
		Group[] groupArray = Groups.toArray(new Group[Groups.size()]);
		
		addChatMessages(groupArray);
		
		
	}


	private static void addChatMessages(Group[] groupArray) {
		
		//adding messages to each group
		//first group
		groupArray[0].addChatMessages1("Hi");
		groupArray[0].addChatMessages2("Hi");
		groupArray[0].addChatMessages1("Hi");
		groupArray[0].addChatMessages2("Hi");
		groupArray[0].addChatMessages1("Hi");
		groupArray[0].addChatMessages2("Hi");
		groupArray[0].addChatMessages1("Hi");
		groupArray[0].addChatMessages2("Hi");
		groupArray[0].addChatMessages1("Hi");
		groupArray[0].addChatMessages2("Hi");
		
		//second group
		groupArray[1].addChatMessages1("Hi");
		groupArray[1].addChatMessages2("Hi");
		groupArray[1].addChatMessages1("Hi");
		groupArray[1].addChatMessages2("Hi");
		groupArray[1].addChatMessages1("Hi");
		groupArray[1].addChatMessages2("Hi");
		groupArray[1].addChatMessages1("Hi");
		groupArray[1].addChatMessages2("Hi");
		groupArray[1].addChatMessages1("Hi");
		groupArray[1].addChatMessages2("Hi");
		groupArray[1].addChatMessages1("Hi");
		groupArray[1].addChatMessages2("Hi");
		
		//third group
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		
		//fourth group
		groupArray[3].addChatMessages1("Hi");
		groupArray[3].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		groupArray[2].addChatMessages1("Hi");
		groupArray[2].addChatMessages2("Hi");
		
		
	}


	//adding students to groups
	private static void addStudentToGroups(TreeSet<Group> groups, HashSet<Student> students) {
		//using an iterator to iterator over student set
		
		Iterator<Student> iter = students.iterator();
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
