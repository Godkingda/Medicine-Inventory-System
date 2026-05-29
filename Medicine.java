import java.time.LocalDate;

// Base class for all medicine types (supports Inheritance requirement)
public class Medicine {

    private int id;
    private String name;
    private int quantity;
    private String expiryDate;
    private String category; // Added for category search

    public Medicine(int id, String name, int quantity, String expiryDate, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.category = category;
    }

    // Backward-compatible constructor (defaults category to "General")
    public Medicine(int id, String name, int quantity, String expiryDate) {
        this(id, name, quantity, expiryDate, "General");
    }

    // Getters
    public int getId()           { return id; }
    public String getName()      { return name; }
    public int getQuantity()     { return quantity; }
    public String getExpiryDate(){ return expiryDate; }
    public String getCategory()  { return category; }

    // Setters
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setCategory(String category) { this.category = category; }

    // Expiry check
    public boolean isExpired() {
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(expiryDate);
        return expiry.isBefore(today);
    }

    // Display method
    public void displayDetails() {
        System.out.println(toString());
    }

    // Subclasses can override for extra info
    public String getExtraInfo() {
        return "";
    }

    @Override
    public String toString() {
        String status = isExpired() ? " ⚠ EXPIRED" : "";
        String extra = getExtraInfo().isEmpty() ? "" : " | " + getExtraInfo();
        return "ID: " + id +
               " | Name: " + name +
               " | Category: " + category +
               " | Quantity: " + quantity +
               " | Expiry: " + expiryDate +
               extra + status;
    }
}
