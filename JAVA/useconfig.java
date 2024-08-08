import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;

    public Database() throws SQLException {
        String url = Config.getProperty("db.url");
        String user = Config.getProperty("db.username");
        String password = Config.getProperty("db.password");
        connection = DriverManager.getConnection(url, user, password);
    }

    public Connection getConnection() {
        return connection;
    }
}