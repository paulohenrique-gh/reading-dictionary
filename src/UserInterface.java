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
		System.out.println("2 - Search entry");
		System.out.println("3 - Back");
		System.out.print(">> ");
		
		
		String option = this.scanner.nextLine();
		
		switch (option) {
		case "1":
			listBooksInShelf();
			selectBook(); // TODO
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
			
			bookList.append("\t" + id + " - " + bookTitle);
			bookList.append("\n");
		});
		
		bookList.deleteCharAt(bookList.length() - 1);
		
		System.out.println(bookList);
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
	
}
