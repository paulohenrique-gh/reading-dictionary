import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
				
		Character kaladin = new Character("Kaladin");
				
		System.out.println("Character name: " + kaladin.getName());
		
		kaladin.setName("Caladin");
		
		System.out.println("New name: " + kaladin.getName());
		
		kaladin.setName("Kaladin");
		kaladin.addNickname("Bridge Boy");
		kaladin.addNickname("Bridge Boy");
		kaladin.addNickname("Sad Boy");
		
		System.out.println("Back to the old name: " + kaladin.getName());
		System.out.println("Nicknames: ");
		kaladin.getNicknames().forEach(nickname -> 
			System.out.println("- " + nickname)
		);
		
		kaladin.addBook(new Book("The Way of Kings", new Author ("Brandon Sanderson")));
		kaladin.addBook(new Book("Words of Radiance", new Author ("Brandon Sanderson")));
		
		System.out.println("Books this character is in: ");
		kaladin.getBooks().forEach(book ->
			System.out.println("- " + book.getTitle())
		);
		
		kaladin.addNote(new Note("Currently a slave working in Bridge Four"));
		kaladin.addNote(new Note("Has a spren named Syl"));
		kaladin.addNote(new Note("Knows how to use the lance"));
		
		System.out.println("Your notes on " + kaladin.getName() + ": ");
		kaladin.getNotes().forEach(note ->
			System.out.println("- " + note.getDescription() + " (created at: " + note.getCreatedAt() + ")")
		);
		
		System.out.println("====================================");
		
		Place shatteredPlains = new Place("Shattered Plains");
		System.out.println("Place name: " + shatteredPlains.getName());
		
		shatteredPlains.setName("The Shattered Plains");
		System.out.println("New place name: " + shatteredPlains.getName());
		
		shatteredPlains.addNickname("Battefield");
		shatteredPlains.addNickname("Chasms");
		
		System.out.println("Your nicknames for " + shatteredPlains.getName() + ": ");
		shatteredPlains.getNicknames().forEach(nickname -> {
			System.out.println("- " + nickname);
		});
		
		System.out.println("====================================");
		
		Author author = new Author("Stephen King");
		System.out.println("Author's name: " + author.getName());
		
		author.setName("J.R.R. Tolkien");	
		System.out.println("Author's new name: " + author.getName());
		
		author.addBook(new Book("The Hobbit", author));
		author.addBook(new Book("The Fellowship of the Ring", author));
		
		System.out.println("Books by " + author.getName() + ": ");
		author.getBooks().forEach(book -> {
			System.out.println("- " + book.getTitle());
		});
		
		System.out.println("====================================");
	
		Dictionary dictionary = new Dictionary();
		
		dictionary.addEntry(kaladin);
		
		System.out.println("Search Kaladin: ");
		System.out.println(dictionary.search(kaladin.getName()));
		
		kaladin.addNote(new Note("Has a tatoo on his forehead"));
		System.out.println();
		System.out.println("Search Kaladin: ");
		System.out.println(dictionary.search(kaladin.getName()));
	}

}
