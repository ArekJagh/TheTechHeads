import java.util.List;


public interface ProductService {
    // CRUD operations
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String id);
    Product findProductById(String id);

    // Additional functionalities
    Product findProductByProductname(String name);
    List<Product> findProductByCategory(String category_name);

    
    // Any other business logic related to User
}