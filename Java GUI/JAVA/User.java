import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;


    public User(String firstName, String lastName, String username, String password, String email) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*public boolean saveToFile(String filePath) {
        String data = userId + "," + username + "," + password + "," + email + "," firstName + "," +lastName;
        return FileUtility.saveRecord(filePath, data);

    }/* */

    public boolean saveToDatabase(Database db) {
        String sql = "INSERT INTO users (userId, firstName, lastName, username, password, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = db.getConnection(); 
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.userId);
            pstmt.setString(2, this.firstName);
            pstmt.setString(3, this.lastName);
            pstmt.setString(4, this.username);
            pstmt.setString(5, this.password);
            pstmt.setString(6, this.email);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } 
    /*public boolean saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("UserId: " + this.userId);
            writer.newLine();
            writer.write("Username: " + this.username);
            writer.newLine();
            writer.write("Password: " + this.password);
            writer.newLine();
            writer.write("Email: " + this.email);
            writer.newLine();
            writer.write("-----");
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    } */


    public boolean authenticate(String password) {
        return password.equals(this.password);
    }

    //private String hashPassword(String password) {
        // Implementation of password hashing
    //}

    // Getter methods
    public String getUserId() {
        return userId;
    }
    public String getfirstName(){
        return firstName;
    }

    public String getlastName(){
        return lastName;
    }
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}