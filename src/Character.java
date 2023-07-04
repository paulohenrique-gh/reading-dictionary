import java.util.ArrayList;
import java.util.List;

public class Character {
	
	private String name;
	private List<String> nicknames;
	private List<Book> books;
	private List<String> descriptions;
	
	public Character(String name) {
		this.name = name;
		this.nicknames = new ArrayList<>();
		this.books = new ArrayList<>();
		this.descriptions = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getNicknames() {
		return this.nicknames;
	}
	
	public void addNickname(String nickname) {
		if (this.nicknames.contains(nickname)) {
			return;
		}
		
		this.nicknames.add(nickname);
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
	
	public List<String> getDescriptions() {
		return this.descriptions;
	}
	
	public void addDescription(String description) {
		this.descriptions.add(description);
	}
	
}
