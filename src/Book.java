import java.util.ArrayList;
import java.util.List;

public class Book {
	
	private String title;
	private Author author;
	private List<Term> entries;
	
	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
		this.entries = new ArrayList<>();
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
	
	public List<Term> getEntries() {
		return this.entries;
	}
	
	public void setEntries() {
		// TODO - create a class Dictionary,
		// after instantiating an object of Dictionary, pass it as argument
		// to setEntries. The method needs to scan the entries and get the ones that
		// have this book (Entry class has an attribute "entries" that is an array of Books)

	}
}

