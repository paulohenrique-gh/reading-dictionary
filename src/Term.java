
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Term {
	
	private String name;
	private List<String> nicknames;
	private Map<Integer, Book> books;
	private Map<Integer, Note> notes;
	private int bookId;
	private int noteId;
	
	public Term(String name) {
		this.name = name;
		this.nicknames = new ArrayList<>();
		this.books = new HashMap<>();
		this.notes = new HashMap<>();
		this.bookId = 0;
		this.noteId = 0;
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
	
	public Map<Integer, Book> getBooks() {
		return this.books;
	}
	
	public boolean addBook(Book book) {
		if (this.books.containsValue(book)) {
			return false;
		}
		this.bookId++;
		this.books.put(this.bookId, book);
		return true;
	}
	
	public boolean removeBookById(int bookId) {
		return this.books.remove(bookId, this.books.get(bookId));
	}
	
	public void printListOfBooks() {
		if (this.books.isEmpty()) {
			System.out.println("\tThis entry has no books associated");
			return;
		}
		
		StringBuilder booksList = new StringBuilder();
		
		this.books.keySet().forEach(id -> {
			Book book = this.books.get(id);
			booksList.append("\t" + id + " - " + book.getTitle() + "\n");
		});
		
		System.out.println(booksList);
	}
	
	public Map<Integer, Note> getNotes() {
		return this.notes;
	}
	
	public void addNote(Note note) {
		this.noteId++;
		this.notes.put(this.noteId, note);
	}
	
	@Override
	public String toString() {
		StringBuilder fullEntry = new StringBuilder();
		fullEntry.append("\t" + this.name + " \n");
		fullEntry.append("\tBooks: \n");
		this.books.keySet().forEach(id -> {
			Book book = this.books.get(id);
			fullEntry.append("\t- " + book.getTitle());
			fullEntry.append("\n");
		});
		fullEntry.append("\tYour notes on " + this.getName() + ": \n");
		this.notes.keySet().forEach(id -> {
			Note note = this.notes.get(id);
			fullEntry.append("\t- " + note.getDescription());
			fullEntry.append("\n");
		});
		
		return fullEntry.toString();
	}
	
	
	
}
