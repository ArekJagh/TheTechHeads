import java.util.List;
import java.util.Optional;

public interface UserService {
    // CRUD operations
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    Optional<User> findUserById(Long id);

    // Additional functionalities
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    List<User> findUsersByLastName(String lastName);

    // Authentication
    Optional<User> authenticate(String username, String password);
    
    // Any other business logic related to User
}