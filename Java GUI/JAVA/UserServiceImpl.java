import java.util.List;

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
    public void deleteUser(String id) {
        User user = userDAO.findById(id);
        if (user != null) {
            userDAO.delete(user);
        }
    }

    @Override
    public User findUserById(String id) {
        return userDAO.findById(id);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public List<User> findUsersByLastName(String lastName) {
        return userDAO.findByLastName(lastName);
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    // Example validation method
    private void validateUser(User user) {
        // Validate username
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        
        // Check if username is unique (e.g., by querying the database)
        if (userDAO.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        
        // Validate password
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        /* 
        // Ensure password complexity (e.g., at least one special character)
        if (!user.getPassword().matches(".*[!@#$%^&*].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }
            */
        /* 
        // Validate email
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Email is not valid");
        }
        */
        // Additional field validations

        // e.g., validate age, phone number, etc.
    }
        // Add more validation logic as needed
    }
