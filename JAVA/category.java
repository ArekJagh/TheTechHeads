public class Category {
    private String categoryId;
    private String name;

    public Category(String name) {
        this.categoryId = UUID.randomUUID().toString();
        this.name = name;
    }

    public boolean saveToDatabase(Database db) {
        // Implementation to save category to database
    }

    // Getter methods
    public String getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}