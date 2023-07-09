import java.util.Scanner;

public class UI {
	private Scanner scanner;
	private Dictionary dictionary;
	private Shelf shelf;
	
	public UI(Scanner scanner, Dictionary dictionary, Shelf shelf) {
		this.scanner = scanner;
		this.dictionary = dictionary;
		this.shelf = shelf;
		
		System.out.println("|====================|");
		System.out.println("| READING DICTIONARY |");
		System.out.println("|====================|");
	}
	
	// Initial menu
		public void start() {
					
			while (true) {
				System.out.println("Choose an option:");
				System.out.println("1 - Create new dictionary");
				System.out.println("2 - Open dictionary");
				System.out.println("3 - Save dictionary");
				System.out.println("4 - Export to PDF");
				System.out.println("5 - Manage shelf");
				System.out.println("6 - Exit");
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
					openDictionary();
				} else if (option.equals("3")) {
					// TODO saveDictionary();
				} else if (option.equals("4")) {
					// TODO exportToPdf();
				} else if (option.equals("5")) {
					// TODO manageShelf();
				}
			}		
		}
		
		// Create new dictionary, overriding the one that was initially loaded
		public void createNewDictionary() {
			this.dictionary = new Dictionary();
		}
		
		// Give user new options for using the dictionary
		public void openDictionary() {
			
			while (true) {
				System.out.println("|====================|");
				System.out.println("1 - Browse by book"); // list all books in shelf
				System.out.println("2 - Search entry"); // must ask user for id of the entry
		 		System.out.println("3 - Back to previous menu");
		 		System.out.println("3 - Back to main menu");
		 		System.out.println("4 - Exit");
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
					browseByBook();
				} else if (option.equals("2")) {
					// TODO searchEntry();
				} else if (option.equals("3")) {
					break;
				} else if (option.equals("4")) {
					start();
					break;
				}
			}		
			
		}
		
		public void browseByBook() {
			// TODO
		}
		
		public boolean isNumeric(String string) {
			return string.matches("^\\d+$");
		}
}
