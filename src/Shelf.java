import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shelf {
	
	private Map<Integer, Book> books;
	private int bookId;
	
	public Shelf() {
		this.books = new HashMap<>();
		this.bookId = 0;
	}
	
	public Map<Integer, Book> getBooks() {
		return this.books;
	}
	
	public void addBook(Book book) {
		if (this.books.values().contains(book)) {
			return;
		}
		this.bookId++;
		this.books.put(this.bookId, book);
	}
	
	public void removeBook(int id) {
		this.books.remove(id);
	}
		
	public List<Author> getAuthors() {
		List<Author> authors = new ArrayList<>();
		
		this.books.values().forEach(book -> {
			if (!authors.contains(book.getAuthor())) {
				authors.add(book.getAuthor());
			}
		});
		
		return authors;
	}
	
	public void printListOfBooks() {
		if (this.bookId == 0) {
			System.out.println("No books have been added yet.");
		}
		
		StringBuilder booksList = new StringBuilder();
		
		this.books.keySet().forEach(id -> {
			booksList.append("\t" + id + " - " + this.books.get(id).getTitle() + "\n");
		});
		
		System.out.println(booksList);
	}

}
