import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Dictionary dictionary = new Dictionary();
		Shelf shelf = new Shelf();
		
		UserInterface ui = new UserInterface(scanner, dictionary, shelf);
		
		ui.start();
						
	}

}
