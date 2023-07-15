import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Dictionary dict = new Dictionary();
		Entry entry = new Entry("Felisin");
		dict.addEntry(entry.getFirstLetter(), entry);
		
		CSVWriter writer = new CSVWriter();
		writer.write(dict);
		
//		UserInterface ui = new UserInterface(scanner, new Dictionary());
//		ui.start();
				
	}

}
