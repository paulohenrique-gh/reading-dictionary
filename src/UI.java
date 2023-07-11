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
		 		if (!isNumeric(input)) {
		 			System.out.println("ID should be a number");
					continue;			
				}
		 		
		 		int bookId = Integer.valueOf(input);;
		 	
				// Print list of entries in book				
				this.shelf.getBooks().get(bookId).printListOfEntries();
				
				openBookSubMenu(bookId);
				break;
				
			}
		}
		
		public void openBookSubMenu(int bookId) {
			while (true) {
				System.out.println("1. Open entry");
				System.out.println("2. Add new entry");
				System.out.println("3. Back to previous menu");
				String option = this.scanner.nextLine();
				if (!isNumeric(option)) {
					continue;
				} 
				
				if (option.equals("1")) {
					openEntry(bookId);
					break;
				}
			}
		}
		
		public void openEntry(int bookId) {
			while (true) {
				System.out.println();
				System.out.println("|==========|");
				System.out.println("|OPEN ENTRY|");
				System.out.println("|==========|");
				System.out.print("Enter entry ID: ");
				String input = this.scanner.nextLine();
		 		if (!isNumeric(input)) {
		 			System.out.println("ID should be a number");
					continue;			
				}
		 		
		 		int entryId = Integer.valueOf(input);
		 		
		 		this.shelf.getBooks().get(bookId).printEntryById(entryId);
		 		openEntrySubMenu(bookId, entryId);
			}
		}
		
		public void openEntrySubMenu(int bookId, int entryId) {
			while (true) {
				System.out.println("1. Edit entry");
				System.out.println("2. Delete entry");
				System.out.println("3. Back to previous menu");
				String option = this.scanner.nextLine();
				if (!isNumeric(option)) {
					continue;
				} 
				
				if (option.equals("1")) {
					editEntry(bookId, entryId);
					break;
				}
			}
		}
		
		public void editEntry(int bookId, int entryId) {
			while (true) {
				System.out.println();
				System.out.println("|==========|");
				System.out.println("|EDIT ENTRY|");
				System.out.println("|==========|");
				System.out.println("1. Edit name");
				System.out.println("2. Edit books");
				System.out.println("3. Edit notes");
				System.out.println("4. Back to previous menu");
				String option = this.scanner.nextLine();
				if (!isNumeric(option)) {
					continue;
				}
				
				if (option.equals("1")) {
					editName(bookId, entryId);
				} 
				if (option.equals("2")){
					editBooks(bookId, entryId);
				}
			}
		}
		
		public void editName(int bookId, int entryId) {
			while (true) {
				System.out.println();
				System.out.println("|=========|");
				System.out.println("|EDIT NAME|");
				System.out.println("|=========|");
				System.out.print("Enter new name: ");
				String input = this.scanner.nextLine();
				if (input.isEmpty()) {
					continue;
				}
				
				this.shelf.getBooks()
					.get(bookId)
					.getEntries()
					.get(entryId)
					.setName(input);
				
				System.out.println("Entry name set to "
						+ this.shelf.getBooks()
							.get(bookId)
							.getEntries()
							.get(entryId)
							.getName());
				break;
			}
		}
		
		public void editBooks(int bookId, int entryId) {
			while (true) {
				System.out.println();
				System.out.println("|==========|");
				System.out.println("|EDIT BOOKS|");
				System.out.println("|==========|");
				
				this.shelf
					.getBooks()
					.get(bookId)
					.getEntries()
					.get(entryId)
					.printListOfBooks();
				
				editBooksSubMenu(bookId, entryId);
			}
		}
		
		public void editBooksSubMenu(int bookId, int entryId) {
			while (true) {
				System.out.println("1. Add new book");
				System.out.println("2. Remove book");
				System.out.println("3. Back to previous menu");
				String option = this.scanner.nextLine();
				if (option.isEmpty()) {
					continue;
				}
				
				if (option.equals("1")) {
					addNewBookToEntry(bookId, entryId);
				}
				if (option.equals("2")) {
					removeBookFromEntry(bookId, entryId);
				}
				if (option.equals("3")) {
					editEntry(bookId, entryId);
					break;
				}
			}
		}
		
		public void addNewBookToEntry(int bookId, int entryId) {
			while (true) {
				System.out.println();
				System.out.println("|============|");
				System.out.println("|ADD NEW BOOK|");
				System.out.println("|============|");
				System.out.print("Enter book title: ");
				String title = this.scanner.nextLine();
				System.out.print("Enter name of the author: ");
				String authorName = this.scanner.nextLine();
				
				Author author = new Author(authorName, this.shelf);
				Book book = new Book(title, author);
				this.shelf.addBook(book);
				if (!this.shelf.getBooks()
					.get(bookId)
					.getEntryById(entryId)
					.addBook(book)) {
					System.out.println("Book already associated with entry");
					continue;
				}
				
				System.out.println("Entry associated with the book " + book.getTitle());
				break;
			}
			
			editBooks(bookId, entryId);
		}
		
		public void removeBookFromEntry(int bookId, int entryId) {
			while (true) {
				System.out.println();
				System.out.println("|======================|");
				System.out.println("|REMOVE BOOK FROM ENTRY|");
				System.out.println("|======================|");
				System.out.print("Enter book ID: ");
				String input = this.scanner.nextLine();
				if (!isNumeric(input)) {
					continue;
				}
				
				int bookToRemoveId = Integer.valueOf(input);
				
				if (!this.shelf.getBooks()
						.get(bookId)
						.getEntries()
						.get(entryId)
						.removeBookById(bookToRemoveId)) {
					System.out.println("Book not found.");
					continue;
				}
				
				System.out.println("Book removed from entry");
				break;
			}
			
			editBooks(bookId, entryId);
		}
		
		public boolean isNumeric(String string) {
			return string.matches("^\\d+$");
		}
}
