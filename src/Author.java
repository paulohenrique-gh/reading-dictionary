import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Author {
	
	private String name;
	private List<Book> books;
		
	public Author(String name, Shelf shelf) {
		this.name = name;
		this.books = new ArrayList<>();
		addBooksFromShelf(shelf);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// Add books shelf that have this author
	public void addBooksFromShelf(Shelf shelf) {
		Map<Integer, Book> bookMap = shelf.getBooks();
		
		bookMap.keySet().forEach(id -> {
			if (bookMap.get(id).getAuthor() == this) {
				this.books.add(bookMap.get(id));
			}
		});
	}
	
	public void addBook(Book book) {
		if (this.books.contains(book)) {
			return;
		}
		
		this.books.add(book);
	}
}
