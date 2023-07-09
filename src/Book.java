import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book {
	
	private String title;
	private Author author;
	private Map<Integer, Term> entries;
	private int entryId;
	
	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
		this.entries = new HashMap<>();
		entryId = 1;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Author getAuthor() {
		return this.author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Map<Integer, Term> getEntries() {
		return this.entries;
	}
	
	public void addEntry(Term entry) {
		// TODO - create a class Dictionary,
		// after instantiating an object of Dictionary, pass it as argument
		// to setEntries. The method needs to scan the entries and get the ones that
		// have this book (Entry class has an attribute "entries" that is an array of Books)
		this.entries.putIfAbsent(this.entryId, entry);
		this.entryId++;
	}
	
	public Term searchEntry(int bookId) {
		return this.entries.getOrDefault(bookId, null);
	}
}

