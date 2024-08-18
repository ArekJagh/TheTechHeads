import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    // Constructor for dependency injection
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void addProduct(Product product) {
        // Perform any necessary validation or preprocessing
        validateProduct(product);
        productDAO.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        // Perform any necessary validation or preprocessing
        validateProduct(product);
        productDAO.update(product);
    }

    @Override
    public void deleteProduct(String id) {
        Product product = productDAO.findById(id);
        if (product != null) {
            productDAO.delete(product);
        }
    }

    @Override
    public Product findProductById(String id) {
        return productDAO.findById(id);
    }

    @Override
    public Product findProductByProductname(String productname) {
        return productDAO.findByName(productname);
    }

    @Override
    public List<Product> findProductByCategory(String category_name) {
        return productDAO.findByCategory(category_name);
    }


    //  validation method
    private void validateProduct(Product product) {
        // Validate username
        if (product.getName() == null) {
            throw new IllegalArgumentException(" Product name cannot be null or empty");
        }
        
        // Check if product name is unique (e.g., by querying the database)
        if (productDAO.findByName(product.getName()) != null) {
            throw new IllegalArgumentException("Product already exists, please choose a different name or update the existing quantity of the product");
        }
        // Validate price
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        // Validate quantity
        if (product.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity must be greater than or equal to zero");
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
