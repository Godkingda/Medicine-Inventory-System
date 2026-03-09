public class Medicine {

    private int id;
    private String name;
    private int quantity;
    private String expiryDate;

    // Constructor
    public Medicine(int id, String name, int quantity, String expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    // Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display medicine information
    public void displayDetails() {
        System.out.println(toString());
    }

    // Convert object to readable string
    @Override
    public String toString() {
        return "ID: " + id +
               " | Name: " + name +
               " | Quantity: " + quantity +
               " | Expiry: " + expiryDate;
    }
}