import java.util.UUID;

public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String categoryId;

    public Product(String name, String description, double price, int quantity, String categoryId) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    // Getter methods
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategoryId() {
        return categoryId;
    }

    // Setter methods
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

}