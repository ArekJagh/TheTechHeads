import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private String userId;
    private List<OrderItem> items;
    private LocalDateTime orderDate;
    private double totalPrice;
    private String status;

    public Order(String userId, List<OrderItem> items) {
        this.orderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = items;
        this.orderDate = LocalDateTime.now();
        this.totalPrice = calculateTotalPrice();
        this.status = "Pending"; // Default status
    }

    private double calculateTotalPrice() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public boolean saveToDatabase(Database db) {
        // Implementation to save order to database
    }

    // Getter methods
    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}