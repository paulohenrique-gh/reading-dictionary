import java.util.ArrayList;
import java.util.List;

public class Author {
	
	private String name;
	private List<Book> books;
		
	public Author(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return this.books;
	}
	
	public void addBook(Book book) {
		if (this.books.contains(book)) {
			return;
		}
		
		this.books.add(book);
	}
}
