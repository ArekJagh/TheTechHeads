import java.util.List;


public interface UserService {
    // CRUD operations
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
    User findUserById(String id);

    // Additional functionalities
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    List<User> findUsersByLastName(String lastName);

    // Authentication
    User authenticate(String username, String password);
    
    // Any other business logic related to User
}