import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Dictionary dictionary = new Dictionary();
		Shelf shelf = new Shelf();
		
		Book mistborn = new Book("Mistborn", new Author("Brandon Sanderson", shelf));
		Book darkTower = new Book("The Dark Tower", new Author("Stephen King", shelf));
		
		mistborn.addEntry(new Character("Kelsier"));
		darkTower.addEntry(new Character("Roland"));
		
		shelf.addBook(mistborn);
		shelf.addBook(darkTower);
		
		UI ui = new UI(scanner, dictionary, shelf);
		
		ui.start();
						
	}

}
