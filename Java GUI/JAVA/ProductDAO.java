import java.util.List;


public interface ProductDAO extends GenericDAO<Product, String> {
    Product findByName (String name);
    List<Product> findByCategory (String category);

}