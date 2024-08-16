import java.util.List;

/**
 * A generic service interface that provides basic CRUD operations for any entity.
 * 
 * @param <T>  The type of the entity.
 * @param <ID> The type of the entity's identifier.
 */
public interface GenericService<T, ID> {
    void save(T entity);
    T findById(ID id);
    List<T> findAll();
    void update(T entity);
    void delete(T entity);

}