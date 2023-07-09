import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
	
	private Scanner scanner;
	private Dictionary dictionary;
	private Shelf shelf;
	
	public UserInterface(Scanner scanner, Dictionary dictionary, Shelf shelf) {
		this.scanner = scanner;
		this.dictionary = dictionary;
		this.shelf = shelf;
	}
	
	
	// Initial menu
	public void start() {
		System.out.println("|====================|");
		System.out.println("| READING DICTIONARY |");
		System.out.println("|====================|");
		
		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1 - Create new dictionary");
			System.out.println("2 - Open dictionary");
			System.out.println("3 - Save dictionary");
			System.out.println("4 - Export to PDF");
			System.out.println("5 - Manage shelf");
			System.out.println("6 - Exit");
			System.out.print(">> ");
			
			String option = this.scanner.nextLine();
			
			if (option.equals("6")) break;
				
			// Process option selected by user
			switch (option) {
			
			case "1":
				createNewDictionary();
				break;
			case "2":
				openDictionary();
				break;
			case "3":
				//TODO
				break;
			case "4":
				//TODO
				break;
			case "5":
				manageShelf();
				break;
			case "6":
				break;
			}
		}		
	}
	
	// Create new dictionary, overriding the one that was initially loaded
	public void createNewDictionary() {
		this.dictionary = new Dictionary();
	}
	
	// Give user new options for using the dictionary
	public void openDictionary() {
		System.out.println("|====================|");
		System.out.println("1 - Browse by book"); // list all books in shelf
		System.out.println("2 - Search entry"); // must ask user for id of the entry
 		System.out.println("3 - Back");
		System.out.print(">> ");
		
		
		String option = this.scanner.nextLine();
		
		switch (option) {
		case "1":
			listBooksInShelf();
			// TODO selectBook();
			break;

		default:
			break;
		}
	}
	
	// Print id and title of books in the shelf
	public void listBooksInShelf() {
		Map<Integer, Book> books = this.shelf.getBooks();
			
		StringBuilder bookList = new StringBuilder();
		
		bookList.append("\tCurrent books in shelf:\n");
		
		books.keySet().forEach(id -> {
			String bookTitle = books.get(id).getTitle();
			
			bookList.append("\t" + id + " - " + bookTitle + "\n");
		});
		
		System.out.println(bookList);
		System.out.println("1 - Select a book");
		System.out.println("2 - Back");
		System.out.print(">> ");
		String option = this.scanner.nextLine();
		
		switch (option) {
		case "1":
			openBook();
			break;
		case "2":
			openDictionary();
			break;
		}
		
	}
	
	public void openBook() {
		String option = "";
		while (true) {
			System.out.println("Enter book ID: ");
			option = scanner.nextLine();
			if (isNumeric(option)) {
				break;
			}
			System.out.println("Invalid ID");
		}
		
		int bookId = Integer.valueOf(option);
		
		String subOption = "";
		while (true) {
			System.out.println("1 - List entries");
			System.out.println("2 - Search entry");
			System.out.println("3 - Add entry");
			System.out.println("4 - Back");
			System.out.print(">> ");
			subOption = scanner.nextLine();
			if (isNumeric(subOption)) {
				break;
			}
			System.out.println("Invalid option");			
		}
		
		switch (subOption) {
		case "1":
			listEntriesInBook(bookId);
			break;
		case "2":
			searchEntry();
			break;
		case "3":
			addEntry(bookId);
			break;
		}
		
	}
	
	public void listEntriesInBook(int bookId) {
		StringBuilder entryList = new StringBuilder();
		
		Map<Integer, Term> entriesMap = this.shelf.getBooks()
				.get(bookId).getEntries();
		
		entriesMap.keySet()
			.forEach(id -> {
				entryList.append("\t" + id + "- " + entriesMap.get(id).getName() + "\n");
			});
		
		System.out.println(entryList);
	}
	
	public void searchEntry() {
		
		String query = "";
		
		while (true) {
			System.out.print("Search for: ");
			query = this.scanner.nextLine().toLowerCase();
			if (!query.isEmpty()) {
				break;
			}
		}
		
		System.out.println(this.dictionary.search(query));
	}
	
	public void addEntry(int bookId) {
		// Book the entry is going to be added to
		Book book = this.shelf.getBooks().get(bookId);
		
		// Name for the entry
		String name = "";
		while (true) {
			System.out.print("Enter a name, a place or other term: ");
			name = this.scanner.nextLine().toLowerCase();
			if (!name.isEmpty()) {
				break;
			}
		}		
		Term entry = new Term(name);
		
		// Add note
		addNote(entry);
				
		entry.addBook(book);		
		book.addEntry(entry);
		
		
		String option = "";
		while (true) {
			System.out.println("1 - Add another note");
			System.out.println("2 - Back");
			System.out.print(">>");
			String input = this.scanner.nextLine();
			if (isNumeric(input)) {
				option = input;
			}
			
			if (option.equals("1")) addNote(entry);
			if (option.equals("2")) {
				openBook();
				break;
			}
		}	
		
	}
	
	public void addNote(Term entry) {
		String note = "";
		while (true) {
			System.out.print("Enter a note: ");
			note = this.scanner.nextLine().toLowerCase();
			if (!note.isEmpty()) {
				break;
			}
		}
		Note entryNote = new Note(note);
		entry.addNote(entryNote);
	}
	
	public void manageShelf() {
		while (true) {
			System.out.println("|====================|");
			System.out.println("1 - List books");
			System.out.println("2 - Add book");
			System.out.println("3 - Remove book");
			System.out.println("4 - Back");
			System.out.print(">> ");
			
			String option = this.scanner.nextLine();
			
			switch (option) {
			case "1":
				listBooksInShelf();
				break;
			case "2":
				addBookToShelf();
				break;
			case "3":
				// TODO
				break;
			case "4":
				start();
				break;
			}
		}
		
	}
	
	public void addBookToShelf() {
		System.out.println("|====================|");
		System.out.print("Enter the title of the book: ");
		String bookTitle = this.scanner.nextLine();
		System.out.print("Enter the author of the book: ");
		String bookAuthor = this.scanner.nextLine();
		
		Author author = new Author(bookAuthor, this.shelf);
		Book book = new Book(bookTitle, author);
		
		this.shelf.addBook(book);
	}
	
	public boolean isNumeric(String string) {
		return string.matches("^\\d+$");
	}
	
	public void browseEntriesInBook() {
		
	}
	
}
