import java.util.List;


public interface UserDAO extends GenericDAO<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByLastName(String lastName);
}