import java.util.*;

public class StudentChat {

	public static void main(String[] args) {

		StringBuilder previousChat = new StringBuilder();

		ChatGraphics chat = new ChatGraphics();
		chat.setVisible(true);
		

		HashSet<Student> Students = new HashSet<Student>();
		addStudent(Students);

		TreeSet<Group> Groups = new TreeSet<Group>();
		addStudentToGroups(Groups, Students);

		Group[] groupArray = Groups.toArray(new Group[Groups.size()]);

		addChatMessages(groupArray);

		LinkedList<String> messageList = new LinkedList<String>();

		for (int i = 0; i < groupArray.length; i++) {
			previousChat.append("\nGroup " + (i + 1) + "\n\n");
			messageList = groupArray[i].getChatLog();

			for (String s : messageList) {
				previousChat.append(s + "\n\n");
			}
		}

		chat.addPreviousChat(previousChat.toString());
		
		chat.connectClientToSever();

	}

	private static void addChatMessages(Group[] groupArray) {

		groupArray[0].addStudent1ChatMessage("Hi");
		groupArray[0].addStudent2ChatMessage("Hi");
		groupArray[0].addStudent1ChatMessage("How are you");
		groupArray[0].addStudent2ChatMessage("Good and you");
		groupArray[0].addStudent1ChatMessage("Good as well");
		groupArray[0].addStudent2ChatMessage("I'm hungery");
		groupArray[0].addStudent1ChatMessage("Get something to eat then");
		groupArray[0].addStudent2ChatMessage("Maybe I will");
		groupArray[0].addStudent1ChatMessage("OK");
		groupArray[0].addStudent2ChatMessage("Goodbye");

		groupArray[1].addStudent1ChatMessage("Hello");
		groupArray[1].addStudent2ChatMessage("Hey");
		groupArray[1].addStudent1ChatMessage("What's Up");
		groupArray[1].addStudent2ChatMessage("Nothing");
		groupArray[1].addStudent1ChatMessage("I like hamburgers");
		groupArray[1].addStudent2ChatMessage("I prefer pizza");
		groupArray[1].addStudent1ChatMessage("Peperoni?");
		groupArray[1].addStudent2ChatMessage("Combo");
		groupArray[1].addStudent1ChatMessage("That's good");
		groupArray[1].addStudent2ChatMessage("Cya later");
		groupArray[1].addStudent1ChatMessage("Later");
		groupArray[1].addStudent2ChatMessage("Bye");

		groupArray[2].addStudent1ChatMessage("Hi");
		groupArray[2].addStudent2ChatMessage("Hi");
		groupArray[2].addStudent1ChatMessage("Getting cold outside");
		groupArray[2].addStudent2ChatMessage("I know I like it");
		groupArray[2].addStudent1ChatMessage("Glad the heat of summer is gone");
		groupArray[2].addStudent2ChatMessage("I'm glad as well");
		groupArray[2].addStudent1ChatMessage("How is work going");
		groupArray[2].addStudent2ChatMessage("Good, how is your work going");
		groupArray[2].addStudent1ChatMessage("It is going good also");
		groupArray[2].addStudent2ChatMessage("I'm glad to hear it");
		groupArray[2].addStudent1ChatMessage("Can't wait to go home ane eat");
		groupArray[2].addStudent2ChatMessage("Me too");
		groupArray[2].addStudent1ChatMessage("Have a good night");
		groupArray[2].addStudent2ChatMessage("Good night");

		groupArray[3].addStudent1ChatMessage("Hi");
		groupArray[3].addStudent2ChatMessage("Hey");
		groupArray[3].addStudent1ChatMessage("Things going well");
		groupArray[3].addStudent2ChatMessage("Yes");
		groupArray[3].addStudent1ChatMessage("How's this assignment");
		groupArray[3].addStudent2ChatMessage("It is interesting");
		groupArray[3].addStudent1ChatMessage("Get all of it done");
		groupArray[3].addStudent2ChatMessage("I hope so");
		groupArray[3].addStudent1ChatMessage("I hope I got it all done also");
		groupArray[3].addStudent2ChatMessage("Good luck on the assignemnt");
		groupArray[3].addStudent1ChatMessage("You to");
		groupArray[3].addStudent2ChatMessage("Fairwell");

	}

	private static void addStudentToGroups(TreeSet<Group> groups, HashSet<Student> students) {

		Iterator<Student> iter = students.iterator();
		Student s1, s2;

		while (iter.hasNext()) {
			s1 = iter.next();
			if (!iter.hasNext()) {
				break;
			}
			s2 = iter.next();
			groups.add(new Group(s1, s2));
		}

	}

	private static void addStudent(HashSet<Student> s) {
		s.add(new Student("Kenyon", "Brown"));
		s.add(new Student("Justin", "Behunin"));
		s.add(new Student("Austin", "Forsling"));
		s.add(new Student("Nicholas", "Goldberg"));
		s.add(new Student("Steven", "Julien"));
		s.add(new Student("Johnathan", "Mirable"));
		s.add(new Student("Tyler", "Hoyer"));
		s.add(new Student("Christopher", "Nash"));
	}

}
