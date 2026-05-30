import java.time.LocalDate;

// ============================================================
// ABSTRACTION: Abstract class — cannot be instantiated directly.
// Defines shared fields/methods for all medicine types.
// Forces subclasses to implement getCategory() and getDosageInfo().
//
// INHERITANCE: Parent class of Tablet, Injection, Syrup.
//
// ENCAPSULATION: All fields private, accessed via getters/setters.
// ============================================================
public abstract class Medicine implements Displayable {

    // ENCAPSULATION: private fields
    private int    id;
    private String name;
    private int    quantity;
    private String expiryDate;
    private double price;

    public Medicine(int id, String name, int quantity, String expiryDate, double price) {
        this.id         = id;
        this.name       = name;
        this.quantity   = quantity;
        this.expiryDate = expiryDate;
        this.price      = price;
    }

    // Getters
    public int    getId()          { return id; }
    public String getName()        { return name; }
    public int    getQuantity()    { return quantity; }
    public String getExpiryDate()  { return expiryDate; }
    public double getPrice()       { return price; }

    // Setters
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price)    { this.price = price; }

    // Expiry check
    public boolean isExpired() {
        return LocalDate.parse(expiryDate).isBefore(LocalDate.now());
    }

    // ABSTRACTION: subclasses must define these
    public abstract String getCategory();
    public abstract String getDosageInfo();

    // Shared display logic (implements Displayable interface)
    @Override
    public void displayDetails() {
        String status = isExpired() ? " ⚠ EXPIRED" : "";
        System.out.println(
            "[" + getCategory() + "] ID: " + id +
            " | Name: " + name +
            " | Qty: " + quantity +
            " | Price: Rs." + price +
            " | Expiry: " + expiryDate + status
        );
        System.out.println("   Dosage: " + getDosageInfo());
    }

    @Override
    public String toString() {
        return getCategory() + "," + id + "," + name + "," + quantity + "," + expiryDate + "," + price + "," + getDosageInfo();
    }
}
