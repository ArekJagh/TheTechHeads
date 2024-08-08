public class OrderItem {
    private String orderItemId;
    private String productId;
    private int quantity;
    private double price;

    public OrderItem(String productId, int quantity, double price) {
        this.orderItemId = UUID.randomUUID().toString();
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    // Getter methods
    public String getOrderItemId() {
        return orderItemId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}