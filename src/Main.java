import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Dictionary dict = new Dictionary();
		Entry entry = new Entry("Felisin");
		entry.addNote(new Note("becomes shaik"));
		Entry entry2 = new Entry("Kaladin");
		entry2.addNote(new Note("bridge boy"));
		entry2.addNote(new Note("has a spren"));
		dict.addEntry(entry.getFirstLetter(), entry);
		dict.addEntry(entry2.getFirstLetter(), entry2);
		
		FileHandler writer = new FileHandler();
		writer.writeDictToCsv(dict);
		writer.readCsv("new_dictionary.csv");
		
		
		
//		UserInterface ui = new UserInterface(scanner, dict);
//		ui.start();
//				
	}

}
