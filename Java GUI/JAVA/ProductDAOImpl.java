import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl extends GenericDAOImpl<Product, String> implements ProductDAO {

    private Database database; // Inject or create an instance of your Database class

    public ProductDAOImpl(Database database) {
        super(Product.class);
        this.database = database;
    }

    @Override
    public Product findByName(String name) {
        String sql = "SELECT * FROM products WHERE product_name = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Product product = mapResultSetToUser(rs);
                    return product;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findByCategory(String category_name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.* FROM products p " +
                     "JOIN category c ON p.category_id = c.id " +
                     "WHERE c.category_name = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, category_name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Product product = mapResultSetToUser(rs);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void save(Product entity) {

        String sql = "INSERT INTO products (id, product_name, product_description, price, quantity, category_id) VALUES (?, ?, ?, ?, ?, ?)";    
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getProductId());
            stmt.setString(2, entity.getName());
            stmt.setDouble(3, entity.getPrice());
            stmt.setInt(4, entity.getQuantity());
            stmt.setString(5, entity.getCategoryId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override 
    public void update(Product entity) {
        String sql = "UPDATE products SET product_name = ?, product_description = ?, price = ?, quantity = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getProductId());
            stmt.setString(2, entity.getName());
            stmt.setDouble(3, entity.getPrice());
            stmt.setInt(4, entity.getQuantity());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void delete(Product entity) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.getProductId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(String id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Product product = mapResultSetToUser(rs);
                    return product;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    




    @Override
    public List<Product> findAll() {
        List<Product> entities = new ArrayList<>();
        // Implement JDBC code to retrieve all entities
        // Example: SELECT * FROM table_name
        try (Connection connection = Database.getConnection()) {
            String sql = "SELECT * FROM products";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Map result set to entity
                    // T entity = mapResultSetToEntity(resultSet);
                    // entities.add(entity);
                    Product product = mapResultSetToUser(resultSet);
                    entities.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return entities;
    }

    private Product mapResultSetToUser(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getString("id"));
        product.setName(rs.getString("product_name"));
        product.setDescription(rs.getString("product_description"));
        product.setPrice(rs.getDouble("price"));

        product.setQuantity(rs.getInt("quantity"));
        product.setCategoryId(rs.getString("category_id"));


        // Set other fields...
        return product;
    }
}