import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public Database(String url, String user, String password) throws SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void executeUpdate(String query) throws SQLException {
        try (var stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw e;
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        try (var stmt = connection.createStatement()) {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            throw e;
        }
    }
}