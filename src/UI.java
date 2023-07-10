import java.util.Scanner;

public class UI {
	private Scanner scanner;
	private Dictionary dictionary;
	private Shelf shelf;
	
	public UI(Scanner scanner, Dictionary dictionary, Shelf shelf) {
		this.scanner = scanner;
		this.dictionary = dictionary;
		this.shelf = shelf;
		
		System.out.println("|==================|");
		System.out.println("|READING DICTIONARY|");
		System.out.println("|==================|");
	}
	
	// Initial menu
		public void start() {
							
			while (true) {
				System.out.println();
				System.out.println("|=========|");
				System.out.println("|MAIN MENU|");
				System.out.println("|=========|");
				System.out.println("1. Create new dictionary");
				System.out.println("2. Load dictionary");
				System.out.println("3. Browse dictionary");				
				System.out.print(">> ");
				String input = this.scanner.nextLine();
				String option = "";
				if (isNumeric(input)) {
					option = input;
				} else {
					continue;
				}
				
				if (option.equals("6")) break;
					
				// Process option selected by user
				if (option.equals("1")) {
					createNewDictionary();
				} else if (option.equals("2")) {
					// TODO loadDictionary();
				} else if (option.equals("3")) {
					browseDictionary();
				}
			}		
		}
		
		// Create new dictionary, overriding the one that was initially loaded
		public void createNewDictionary() {
			this.dictionary = new Dictionary();
		}
		
		// Give user new options for using the dictionary
		public void browseDictionary() {			
			
			while (true) {
				System.out.println();
				System.out.println("|=================|");
				System.out.println("|BROWSE DICTIONARY|");
				System.out.println("|=================|");
				System.out.println("1. View entries by book"); 
				System.out.println("2. Search entry"); 
		 		System.out.println("3. Back to previous menu");
		 		System.out.println("4. Exit");
				System.out.print(">> ");
				String input = this.scanner.nextLine();
				String option = "";
				if (isNumeric(input)) {
					option = input;
				} else {
					continue;
				}
				
				if (option.equals("4")) {
					System.exit(0);
				}
				
				if (option.equals("1")) {
					viewEntriesByBook();
					break;
				} else if (option.equals("2")) {
					// TODO searchEntry();
					break;
				} else if (option.equals("3")) {
					start();
					break;
				}
			}		
			
		}
		
		public void viewEntriesByBook() {
			while (true) {
				System.out.println();
				System.out.println("|====================|");
				System.out.println("|VIEW ENTRIES BY BOOK|");
				System.out.println("|====================|");
				
				// Print list of books in shelf
				this.shelf.printListOfBooks();

				System.out.println("1. Open book"); 
		 		System.out.println("2. Back to previous menu");
		 		System.out.print(">> ");
		 		String input = this.scanner.nextLine();
				String option = "";
		 		if (isNumeric(input)) {
					option = input;
				} else {
					continue;
				}
		 		
		 		if (option.equals("1")) {
		 			openBook();
		 			break;
		 		} else if (option.equals("2")) {
		 			browseDictionary();
		 			break;
		 		}
			}
		}
		
		public void openBook() {
			while (true) {
				System.out.println();
				System.out.println("|=========|");
				System.out.println("|OPEN BOOK|");
				System.out.println("|=========|");
				System.out.print("Enter book ID: ");
				String input = this.scanner.nextLine();
				String option = "";
		 		if (isNumeric(input)) {
					option = input;
				} else {
					System.out.println("ID should be a number");
					continue;
				}
		 		
		 		int bookId = Integer.valueOf(option);
		 		
				// Print list of entries in book				
				this.shelf.getBooks().get(bookId).printListOfEntries();
				
				openBookSubMenu();
				
			}
		}
		
		public boolean openBookSubMenu() {
			while (true) {
				System.out.println("1. Open entry");
				System.out.println("2. Add new entry");
				System.out.println("3. Back to previous menu");
			}
		}
		
		public boolean isNumeric(String string) {
			return string.matches("^\\d+$");
		}
}
