import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    // Constructor for dependency injection
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(User user) {
        // Perform any necessary validation or preprocessing
        validateUser(user);
        userDAO.save(user);
    }

    @Override
    public void updateUser(User user) {
        // Perform any necessary validation or preprocessing
        validateUser(user);
        userDAO.update(user);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userDAO.findById(id);
        user.ifPresent(userDAO::delete);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public List<User> findUsersByLastName(String lastName) {
        return userDAO.findByLastName(lastName);
    }

    @Override
    public Optional<User> authenticate(String username, String password) {
        Optional<User> user = userDAO.findByUsername(username);
        return user.filter(u -> u.getPassword().equals(password));
    }

    // Example validation method
    private void validateUser(User user) {
        // Validate username
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        // Check if username is unique (e.g., by querying the database)
        if (userDAO.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        
        // Validate password
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        
        // Ensure password complexity (e.g., at least one special character)
        if (!user.getPassword().matches(".*[!@#$%^&*].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }
        
        // Validate email
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Email is not valid");
        }
        
        // Additional field validations

        // e.g., validate age, phone number, etc.
    }
        // Add more validation logic as needed
    }
