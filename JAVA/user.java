
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.SqlException;
import java.sql.Connection;

public class User {
    private String userId;
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
        this.password = hashPassword(password);
        this.email = email;
    }

    public boolean saveToDatabase(Database db) {
        // Implementation to save user to database
        String sql = "INSERT INTO users (userId, username, password, email) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql) {
                pstmt.setString(1, this.userId);
                pstmt.setString(2,this.username);
                pstmt.setString(3, this.password);
                pstmt.setString(4, this.email);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

    }

    public boolean authenticate(String password) {
        return hashPassword(password).equals(this.password);
    }

    private String hashPassword(String password) {
        // Implementation of password hashing
    }

    // Getter methods
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}