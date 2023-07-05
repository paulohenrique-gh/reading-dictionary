import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	private String url;
	private String username;
	private String password;
	private Connection connection;
	
	public DAO(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public void connect() {
		
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			String url = "jdbc:mysql://127.0.0.1:3306/reading_dictionary";
//			String username = "root";
//			String password = "db@2023";
			
			Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
			
//			String sql = "INSERT INTO books (title, author, genre, series, number_in_series) VALUES (?, ?, ?, ?, ?)";
//			
//			PreparedStatement preparedStmt = conn.prepareStatement(sql);
//			preparedStmt.setString(1, "The Well Of Ascension");
//			preparedStmt.setString(2, "Brandon Sanderson");
//			preparedStmt.setString(3, "Fantasy");
//			preparedStmt.setString(4, "Mistborn");
//			preparedStmt.setInt(5, 2);			
//			
//			preparedStmt.execute();
			
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM books");
					
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("title"));
			}
						
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
