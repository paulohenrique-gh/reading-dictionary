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
		

	}

}
