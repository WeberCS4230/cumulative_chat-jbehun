import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class StudentChat {

	public static void main(String[] args) {
		
		HashSet<Student> Students = new HashSet<Student>(); //hashset prevents duplicates
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
		System.out.println(Groups.size());
		
		addChatMessages(groupArray);
		
		//printing out chat messages
		LinkedList<String> messageList = new LinkedList<String>(); 
		
		System.out.println("\nChat Message by group");
		for(int i = 0 ; i < groupArray.length - 1; i++) {
			System.out.println("\nGroup " + (i + 1) +"\n");
			messageList = groupArray[i].getChatLog();
			
			for(Object s: messageList) {
				System.out.println(s);
			}
		}
		
		
	}


	private static void addChatMessages(Group[] groupArray) {
		
		//adding messages to each group
		//first group
		groupArray[0].addChatMessages1("Hi");
		groupArray[0].addChatMessages2("Hi");
		groupArray[0].addChatMessages1("How are you");
		groupArray[0].addChatMessages2("Good and you");
		groupArray[0].addChatMessages1("Good as well");
		groupArray[0].addChatMessages2("I'm hungery");
		groupArray[0].addChatMessages1("Get something to eat then");
		groupArray[0].addChatMessages2("Maybe I will");
		groupArray[0].addChatMessages1("OK");
		groupArray[0].addChatMessages2("Goodbye");
		
		//second group
		groupArray[1].addChatMessages1("Hello");
		groupArray[1].addChatMessages2("Hey");
		groupArray[1].addChatMessages1("What's Up");
		groupArray[1].addChatMessages2("Nothing");
		groupArray[1].addChatMessages1("I like hamburgers");
		groupArray[1].addChatMessages2("I prefer pizza");
		groupArray[1].addChatMessages1("Peperoni?");
		groupArray[1].addChatMessages2("Combo");
		groupArray[1].addChatMessages1("That's good");
		groupArray[1].addChatMessages2("Cya later");
		groupArray[1].addChatMessages1("Later");
		groupArray[1].addChatMessages2("Bye");
		
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
