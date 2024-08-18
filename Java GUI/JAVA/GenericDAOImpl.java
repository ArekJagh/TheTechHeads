import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A generic DAO implementation that provides basic CRUD operations for any entity using JDBC.
 * 
 * @param <T>  The type of the entity.
 * @param <ID> The type of the entity's identifier.
 */
public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    // Class type of the entity. This is used to know the type of entity it is working with.
    private Class<T> persistentClass;

    /**
     * Constructor that initializes the generic DAO with the class type of the entity and the database connection manager.
     * 
     * @param persistentClass The class type of the entity (e.g., Customer.class).
     */
    public GenericDAOImpl(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    /**
     * Saves a new entity to the database.
     * 
     * @param entity The entity to be saved.
     */
    @Override
    public void save(T entity) {
        // Implement JDBC code to save the entity
        // Example: INSERT INTO table_name (columns) VALUES (values)
        try (Connection connection = Database.getConnection()) {
            String sql = "INSERT INTO " + persistentClass.getSimpleName() + " (...) VALUES (...)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set parameters for the statement
                // statement.setXXX(1, entity.getXXX());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds an entity by its primary key (ID).
     * 
     * @param id The ID of the entity.
     * @return The entity found, or null if no entity with the specified ID exists.
     */
    @Override
    public T findById(ID id) {
        // Implement JDBC code to find the entity by ID
        // Example: SELECT * FROM table_name WHERE id = ?
        T entity = null;
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM " + persistentClass.getSimpleName() + " WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set parameters for the statement
                // statement.setXXX(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        // Map result set to entity
                        // entity = mapResultSetToEntity(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * Retrieves all entities of the given type from the database.
     * 
     * @return A list of all entities of the specified type.
     */
    @Override
    public List<T> findAll() {
        List<T> entities = new ArrayList<>();
        // Implement JDBC code to retrieve all entities
        // Example: SELECT * FROM table_name
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM " + persistentClass.getSimpleName();
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Map result set to entity
                    // T entity = mapResultSetToEntity(resultSet);
                    // entities.add(entity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    /**
     * Updates an existing entity in the database.
     * 
     * @param entity The entity with updated data.
     */
    @Override
    public void update(T entity) {
        // Implement JDBC code to update the entity
        // Example: UPDATE table_name SET column1 = ?, column2 = ? WHERE id = ?
        try (Connection connection = Database.getConnection()) {
            String sql = "UPDATE " + persistentClass.getSimpleName() + " SET ... WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set parameters for the statement
                // statement.setXXX(1, entity.getXXX());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an entity from the database.
     * 
     * @param entity The entity to be deleted.
     */
    @Override
    public void delete(T entity) {
        // Implement JDBC code to delete the entity
        // Example: DELETE FROM table_name WHERE id = ?
        try (Connection connection = Database.getConnection()) {
            String sql = "DELETE FROM " + persistentClass.getSimpleName() + " WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                // Set parameters for the statement
                // statement.setXXX(1, entity.getXXX());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // Implement a method to map ResultSet to entity
    // private T mapResultSetToEntity(ResultSet resultSet) {
    //     // Map result set to entity
    //     return null;
    // }
}