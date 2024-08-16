public interface UserDAO extends GenericDAO<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    List<User> findByLastName(String lastName);
}