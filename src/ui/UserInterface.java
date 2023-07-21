package ui;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Dictionary;
import entities.Entry;
import entities.FileHandler;
import entities.Note;

public class UserInterface {
	
	private Scanner scanner;
	private Dictionary dictionary;
	
	// Constructor takes a scanner and a dictionary object
	public UserInterface(Scanner scanner) {
		this.scanner = scanner;
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
				try {
					FileHandler handler = new FileHandler();
					this.dictionary = handler.readCsv("new_dictionary.csv");
				} catch (FileNotFoundException e) {
					System.out.println("\tError. File not found.");
				}
				openDictionary();
				continue;
			}
			if (option.equals("2")) {				
				setDictionary(new Dictionary());
				System.out.println("\tNew dictionary created");
				continue;
			}
			if (option.equals("3")) {
				this.dictionary.saveToCsv();
				continue;
			}
			if (option.equals("4")) {
				printMenuHeader("EXIT");
				System.exit(0);;
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

	// Option 1 in the main menu
	public void openDictionary() {
		printMenuHeader("OPEN DICTIONARY");
		
		String[] menuOptions = new String[] {
				"Select an entry",
				"Add new entry",
				"Back"
		};
		
		while (true) {
			System.out.print("Enter letter from A to Z or 0 to go to previous menu: ");
			char letter = this.scanner.nextLine().charAt(0);
			
			if (letter == '0') start();

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
					
					if (isValidMenuOption(this.dictionary.getSizeInLetter(), input)) {
						int entryId = Integer.valueOf(input);
						openEntry(letter, entryId);
					} else {
						System.out.println("Invalid option");
					}
					continue;
				}
				if (option.equals("2")) {				
					addEntry();
					continue;
				}
				if (option.equals("3")) {
					break;
				}

			} else {
				System.out.print("Add entry? (y/n): ");
				String option = this.scanner.nextLine().toLowerCase();
				if (option.equals("y")) { 
					addEntry();
					continue;
				}
				if (option.equals("n")) {
					start();
					break;
				}
			}
		}
		
	}

	// Open options for what to do with an entry
	public void openEntry(char letter, int entryId) {
		printMenuHeader("OPEN ENTRY");
		
		this.dictionary.getEntry(letter, entryId).printEntry();
		
		String[] options = new String[] {
			"Edit entry",
			"Delete entry",
			"Back"
		};
		
		while (true) {
			
			printMenuOptions(options);			
			String option = this.scanner.nextLine();
			
			if (!isValidMenuOption(3, option)) {
				System.out.println("Invalid option");
				continue;
			}
			
			if (option.equals("1")) {
				editEntry(letter, entryId);
				continue;
			}
			if (option.equals("2")) {				
				this.dictionary.removeEntry(letter, entryId); 
				System.out.println("\n\tEntry removed!\n");
				break;
			}
			if (option.equals("3")) {
				break;
			}
		}
		
		openDictionary();

	}
		

	// Add and delete notes from entry
	public void editEntry(char letter, int entryId) {
		printMenuHeader("EDIT ENTRY");
		
		this.dictionary.getEntry(letter, entryId).printEntry();
		
		String[] options = new String[] {
				"Add note",
				"Delete note",
				"Back"
		};
		
		while (true) {
			
			printMenuOptions(options);
			String option = this.scanner.nextLine();
			
			if (!isValidMenuOption(3, option)) {
				System.out.println("Invalid option");
				continue;
			}
			if (option.equals("1")) {
				addNoteToEntry(letter, entryId);
				break;
			}
			if (option.equals("2")) {
				deleteNoteFromEntry(letter, entryId);
				break;
			}
			if (option.equals("3")) {
				
				break;
			}
		}
		
		openEntry(letter, entryId);
	}
	
	public void addNoteToEntry(char letter, int entryId) {
		printMenuHeader("ADD NOTE");
		
		this.dictionary.getEntry(letter, entryId).printEntry();
		
		System.out.print("Enter note to the current entry: ");
		String description = this.scanner.nextLine();
		
		Note note = new Note(description);
		this.dictionary.getEntry(letter, entryId).addNote(note);
		
		System.out.println("\n\tNote added!");
		
		editEntry(letter, entryId);
	}
	
	public void deleteNoteFromEntry(char letter, int entryId) {
		printMenuHeader("DELETE NOTE");
		
		this.dictionary.getEntry(letter, entryId).printEntry();
		
		while (true) {
			System.out.print("Enter note ID: ");
			String input = this.scanner.nextLine();
			
			if (isValidMenuOption(this.dictionary.
					getEntry(letter, entryId).
					getNoteQuantity(), input)) {
					int noteId = Integer.valueOf(input);
					this.dictionary.getEntry(letter, entryId).
						removeNoteById(noteId);
					
					System.out.println("\n\tNote deleted!\n");
					break;
			} else {
				System.out.println("\n\tInvalid ID\n");
			}
		}
		
		editEntry(letter, entryId);
		
	}	
	
	public void addEntry() {
		printMenuHeader("ADD ENTRY");
		
		System.out.print("Enter name: ");
		String name = this.scanner.nextLine();
		System.out.print("Enter note: ");
		String description = this.scanner.nextLine();
		Note note = new Note(description);
		Entry entry = new Entry(name, note);
		
		if (this.dictionary.addEntry(entry)) {
			System.out.println("\n\tEntry added successfully\n");
			openDictionary();
		} else {
			System.out.println("\n\tAn error has ocorred\n");
			addEntry();
		}	
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
