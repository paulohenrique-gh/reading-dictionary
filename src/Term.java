
import java.util.ArrayList;
import java.util.List;

public class Term {
	
	private String name;
	private List<String> nicknames;
	private List<Book> books;
	private List<Note> notes;
	
	public Term(String name) {
		this.name = name;
		this.nicknames = new ArrayList<>();
		this.books = new ArrayList<>();
		this.notes = new ArrayList<>();
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
	
	public List<Note> getNotes() {
		return this.notes;
	}
	
	public void addNote(Note note) {
		this.notes.add(note);
	}
	
	@Override
	public String toString() {
		StringBuilder fullEntry = new StringBuilder();
		fullEntry.append(this.name + ": \n");
		fullEntry.append("Also known as: \n");
		this.nicknames.forEach(nickname -> {
			fullEntry.append("- " + nickname);
			fullEntry.append("\n");
		});
		fullEntry.append("Books featuring " + this.name + ": \n");
		this.books.forEach(book -> {
			fullEntry.append("- " + book.getTitle());
			fullEntry.append("\n");
		});
		fullEntry.append("Your notes on " + this.getName() + ": \n");
		this.notes.forEach(note -> {
			fullEntry.append("- " + note.getDescription());
			fullEntry.append("\n");
		});
		
		return fullEntry.toString();
	}
}
