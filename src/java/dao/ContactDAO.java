package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contact;
/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class ContactDAO {
    
    
	private String jdbcURL = "jdbc:mysql://localhost:3306/dbtravel?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	private static final String select_allcontact = "select * from contact";
        private static final String insert_contact = "INSERT INTO contact" + "  (name, email, phone, message) VALUES "
			+ " (?, ?, ?, ?);";

	public ContactDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}



	public List<Contact> selectAllContact() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Contact> gallery = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(select_allcontact);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
                                String phone = rs.getString("phone");
				String message = rs.getString("message");
				gallery.add(new Contact(id, name, email, phone, message));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return gallery;
	}
        
        
        public void insertContact(Contact contact) throws SQLException {
		System.out.println(insert_contact);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(insert_contact)) {
			preparedStatement.setString(1, contact.getName());
			preparedStatement.setString(2, contact.getEmail());
			preparedStatement.setString(3, contact.getPhone());
                        preparedStatement.setString(4, contact.getMessage());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
