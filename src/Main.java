import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
				
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(
			  "jdbc:mysql://aws.connect.psdb.cloud/reading_dictionary?sslMode=VERIFY_IDENTITY",
			  "0i9ofeowa18id8hiqt64",
			  "pscale_pw_FGWJIyqkiOmhc161WNwQxPCNn3sDeu6NmqKZwQ5Macw");
			
			String sql = "INSERT INTO books (title, author, genre, series, number_in_series) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, "The Well Of Ascension");
			preparedStmt.setString(2, "Brandon Sanderson");
			preparedStmt.setString(3, "Fantasy");
			preparedStmt.setString(4, "Mistborn");
			preparedStmt.setInt(5, 2);			
			
			preparedStmt.execute();
			
			Statement stmt = conn.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM books");
					
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " +
								   resultSet.getString(3) + " " + resultSet.getString(4) + " " +
								   resultSet.getString(5) + " " + resultSet.getInt(6));
			}
			
			
			conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
