import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		Note note = new Note("Description");
//		
//		System.out.println("Note description: " + note.getDescription());
//		note.setDescription("New description");
//		System.out.println("New note description: " + note.getDescription());
//		
//		Entry entry = new Entry("Nonono");
//		System.out.println("Entry name: " + entry.getName());
//		System.out.println("Entry name: " + entry.getName());
//		System.out.println(entry);
//		entry.addNote(note);
//		System.out.println(entry);
//		
//		Note note2 = new Note("Second description");
//		entry.addNote(note2);
//		System.out.println(entry);
//		
//		entry.removeNote(note);
//		System.out.println(entry);
//		
//		for (int id : entry.getNotes().keySet()) {
//			System.out.println(entry.getNotes().get(id).getDescription());
//		}
//		
//		System.out.println("current first letter: " + entry.getFirstLetter());
//		
//		System.out.println("new name: " + entry.getName());
//		System.out.println("new first letter: " + entry.getFirstLetter());
//		
//		
//		Dictionary dictionary = new Dictionary();
//		
//		System.out.println("Added? " + dictionary.addEntry(entry));
//		System.out.println("is entry in dictionary: " + dictionary.isInDictionary(entry));
//		
//		Entry newEntry1 = new Entry("Entry 1");
//		Entry newEntry2 = new Entry("Entry 2");
//		Entry newEntry3 = new Entry("Entry 3");
//		Entry newEntry4 = new Entry("Entry 4");
//		Entry newEntry5 = new Entry("Entry 5");
//		Entry newEntry6 = new Entry("Entry 6");
//		
//		dictionary.addEntry(newEntry1);
//		dictionary.addEntry(newEntry2);
//		dictionary.addEntry(newEntry3);
//		dictionary.addEntry(newEntry4);
//		dictionary.addEntry(newEntry5);
//		dictionary.addEntry(newEntry6);
//		
//		dictionary.printEntriesByFirstLetter(newEntry1.getFirstLetter());
//		
//		System.out.println(dictionary.addEntry(new Entry("new new new entry")));
//		
//		dictionary.printEntriesByFirstLetter('n');
		
		Dictionary dict = new Dictionary();
		
		UserInterface ui = new UserInterface(scanner, dict);
		
		System.out.println(dict);
		System.out.println(ui.getDictionary());

		System.out.println(ui.getDictionary());
		
//		ui.openDictionary();
		
		String[] options = new String[]{"Option 1",
		                              "Option 2",
		                              "Option 3"};
		
//		ui.start();		
		
		System.out.println(ui.isValidMenuOption(3, ";"));
		
		System.out.println("2".matches("^\\d$"));
		
		Entry entry1 = new Entry("A Test entry");
		Entry entry2 = new Entry("A Test entry");
		Entry entry3 = new Entry("B Test entry");
		Entry entry4 = new Entry("B Test entry");
		dict.addEntry(entry1);
		dict.addEntry(entry2);
		dict.addEntry(entry3);
		dict.addEntry(entry4);
		
		ui.start();
		
		
	}

}
