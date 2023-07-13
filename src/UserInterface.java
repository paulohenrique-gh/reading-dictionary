import java.util.Scanner;

public class UserInterface {
	
	private Scanner scanner;
	private Dictionary dictionary;
	
	// Constructor takes a scanner and a dictionary object
	public UserInterface(Scanner scanner, Dictionary dictionary) {
		this.scanner = scanner;
		this.dictionary = dictionary;
	}
	
	// Print header for the menus
	public void printMenuHeader(String header) {
		System.out.println("\n:::::::: " + header + " ::::::::");
	}
	
	// Print menu options, takes an array with all the options
	public void printMenuOptions(String[] options) {
		StringBuilder menu = new StringBuilder();
		
		int length = options.length;
		for (int i = 0; i < length; i++) {
			menu.append(i + 1 + ". " + options[i] + "\n");
		}
		menu.append("> ");
		System.out.print(menu);
	}
	
	// Main menu
	public void start() {
		printMenuHeader("READING DICTIONARY");
		
		while (true) {
			String[] menuOptions = new String[] {
				"Open Dictionary",
				"New Dictionary",
				"Save",
				"Exit"
			};
			printMenuOptions(menuOptions);
			
			String option = this.scanner.nextLine();
			
			if (!isValidMenuOption(4, option)) {
				System.out.println("Invalid option\n");
				continue;
			}
			
			if (option.equals("1")) {
				openDictionary();
				continue;
			}
			if (option.equals("2")) {				
				setDictionary(new Dictionary());
				System.out.println("\tNew dictionary created");
				continue;
			}
			if (option.equals("3")) {
				// TODO
				continue;
			}
			if (option.equals("4")) {
				break;
			}
			
		}
		
	}
	
	// Set new dictionary. Used by option Create new Dictionary in the main menu
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
	// Return dictionary reference
	public Dictionary getDictionary() {
		return this.dictionary;
	}
	
	// WIP
	// Option 1 in the main menu
	public void openDictionary() {
		printMenuHeader("OPEN DICTIONARY");
		
		String[] menuOptions = new String[] {
				"Select an entry",
				"Add new entry",
				"Back"
		};
		
		while (true) {
			System.out.print("Enter letter from A to Z: ");
			char letter = this.scanner.nextLine().charAt(0);
			
			if (this.dictionary.printEntriesByFirstLetter(letter)) {
				
				printMenuOptions(menuOptions);				
				String option = this.scanner.nextLine();
				
				if (!isValidMenuOption(3, option)) {
					System.out.println("Invalid option");
					continue;
				}
				
				if (option.equals("1")) {
					System.out.print("Enter ID: ");
					String input = this.scanner.nextLine();
					
					if (isValidMenuOption(this.dictionary.getEntryId(), input)) {
						int entryId = Integer.valueOf(this.scanner.nextLine());
						openEntry(entryId);
					} else {
						System.out.println("Invalid option");
					}
					continue;
				}
				if (option.equals("2")) {				
					// TODO
					continue;
				}
				if (option.equals("3")) {
					break;
				}

			}
		}
		
	}

	// Open options for what to do with an entry
	// WIP
	public void openEntry(int entryId) {
		printMenuHeader("VIEW ENTRY");
		
		
		String[] options = new String[] {
			"Edit entry",
			"Delete entry",
			"Back"
		};
		
		while (true) {
			
			printMenuOptions(options);			
			String option = this.scanner.nextLine();
			
			if (option.equals("1")) {
				// NEXT				
				continue;
			}
			if (option.equals("2")) {				
				// TODO
				continue;
			}
			if (option.equals("3")) {
				break;
			}
		}
		

		System.out.println("Invalid input");
	}
	
	// Check if menu option or entry id provided user is valid
	public boolean isValidMenuOption(int max, String selection) {

		if (!selection.matches("^\\d$")) {
			return false;
		}
		
		int numSelection = Integer.valueOf(selection);
		if (numSelection < 1 || numSelection > max) {
			return false;
		}
		
		return true;
	}
}
