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
		entryId = 0;
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
		if (this.entries.containsValue(entry)) {
			return;
		}
		this.entryId++;
		this.entries.put(this.entryId, entry);		
	}
	
	public Term searchEntry(int bookId) {
		return this.entries.getOrDefault(bookId, null);
	}
	
	public void printListOfEntries() {
		if (this.entryId == 0) {
			System.out.println("No entries have been added to this book yet");
		}
		
		StringBuilder entriesList = new StringBuilder();
		
		this.entries.keySet().forEach(id -> {
			entriesList.append("\t" + id + " - " + this.entries.get(id).getName() + "\n");
		});
		
		System.out.println(entriesList);
	}
}

