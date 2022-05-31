package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import model.Local;


/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 *
 * @author Ramesh Fadatare
 *
 */
public class LocalDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/dbtravel?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String insert_local = "INSERT INTO search" + "  (name, image, country) VALUES "
            + " (?, ?, ?);";

    private static final String select_local_byid = "select id,name,image,country from search where id =?";
    private static final String select_local_bytxt = "select id,name,image,country from search where country =?";
    private static final String select_alllocal = "select * from search";
    private static final String select_local_limit= "SELECT * FROM search LIMIT ?, 3";

    public LocalDAO() {
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

    public void insertLocal(Local user) throws SQLException {
        System.out.println(insert_local);
        // try-with-resource statement will auto close the connection.
        try ( Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(insert_local)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getImage());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Local selectLocal(int id) {
        Local user = null;
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(select_local_byid);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String image = rs.getString("image");
                String country = rs.getString("country");
                user = new Local(id, name, image, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<Local> selectAllLocalBytxt(String txt) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Local> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(select_local_bytxt);) {
            preparedStatement.setString(1, txt);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String country = rs.getString("country");
                users.add(new Local(id, name, image, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    
    
    
    public List<Local> selectAllLocallimit(int a) {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Local> listLimit = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(select_local_limit);) {
            preparedStatement.setInt(1,(a-1)*3);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String country = rs.getString("country");
                listLimit.add(new Local(id, name, image, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listLimit;
    }
    
    

    public List<Local> selectAllLocal() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Local> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try ( Connection connection = getConnection(); // Step 2:Create a statement using connection object
                  PreparedStatement preparedStatement = connection.prepareStatement(select_alllocal);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String image = rs.getString("image");
                String country = rs.getString("country");
                users.add(new Local(id, name, image, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
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
