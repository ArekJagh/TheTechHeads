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

    public boolean saveToDatabase(Database db) {
        // Implementation to save product to database
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
}