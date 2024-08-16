import java.util.List;

/**
 * A generic service implementation that provides basic CRUD operations by delegating
 * them to a corresponding GenericDAO instance.
 * 
 * @param <T>  The type of the entity.
 * @param <ID> The type of the entity's identifier.
 */
public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    // The DAO instance used to perform database operations.
    private GenericDAO<T, ID> genericDAO;

    /**
     * Constructor that initializes the service with a specific DAO implementation.
     * 
     * @param genericDAO The DAO instance to be used by this service.
     */
    public GenericServiceImpl(GenericDAO<T, ID> genericDAO) {
        this.genericDAO = genericDAO;
    }

    /**
     * Saves a new entity by delegating the call to the DAO's save method.
     * 
     * @param entity The entity to be saved.
     */
    @Override
    public void save(T entity) {
        genericDAO.save(entity);  // Delegate the save operation to the DAO.
    }

    /**
     * Finds an entity by its primary key (ID) by delegating the call to the DAO's findById method.
     * 
     * @param id The ID of the entity to find.
     * @return The entity found, or null if no entity with the specified ID exists.
     */
    @Override
    public T findById(ID id) {
        return genericDAO.findById(id);  // Delegate the find operation to the DAO.
    }

    /**
     * Retrieves all entities of the given type by delegating the call to the DAO's findAll method.
     * 
     * @return A list of all entities of the specified type.
     */
    @Override
    public List<T> findAll() {
        return genericDAO.findAll();  // Delegate the findAll operation to the DAO.
    }

    /**
     * Updates an existing entity by delegating the call to the DAO's update method.
     * 
     * @param entity The entity with updated data.
     */
    @Override
    public void update(T entity) {
        genericDAO.update(entity);  // Delegate the update operation to the DAO.
    }

    /**
     * Deletes an entity by delegating the call to the DAO's delete method.
     * 
     * @param entity The entity to be deleted.
     */
    @Override
    public void delete(T entity) {
        genericDAO.delete(entity);  // Delegate the delete operation to the DAO.
    }
}