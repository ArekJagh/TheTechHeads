import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * A generic DAO implementation that provides basic CRUD operations for any entity.
 * 
 * @param <T>  The type of the entity.
 * @param <ID> The type of the entity's identifier.
 */
public abstract class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    // Class type of the entity. This is used by the EntityManager to know the type of entity it is working with.
    private Class<T> persistentClass;

    // The EntityManager is used to interact with the persistence context (usually a database).
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Constructor that initializes the generic DAO with the class type of the entity.
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
        entityManager.persist(entity);  // The persist method makes the entity managed and persistent.
    }

    /**
     * Finds an entity by its primary key (ID).
     * 
     * @param id The ID of the entity.
     * @return The entity found, or null if no entity with the specified ID exists.
     */
    @Override
    public T findById(ID id) {
        // The find method retrieves an entity from the database by its primary key.
        return entityManager.find(persistentClass, id);
    }

    /**
     * Retrieves all entities of the given type from the database.
     * 
     * @return A list of all entities of the specified type.
     */
    @Override
    public List<T> findAll() {
        // Creates a JPQL query to select all entities of the given type.
        return entityManager.createQuery("from " + persistentClass.getName(), persistentClass).getResultList();
    }

    /**
     * Updates an existing entity in the database.
     * 
     * @param entity The entity with updated data.
     */
    @Override
    public void update(T entity) {
        // The merge method updates the entity in the database. It returns the managed entity instance.
        entityManager.merge(entity);
    }

    /**
     * Deletes an entity from the database.
     * 
     * @param entity​⬤