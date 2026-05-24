import java.time.LocalDate;

public abstract class Medicine {

    private int id;
    private String name;
    private int quantity;
    private String expiryDate;

    public Medicine(int id, String name, int quantity, String expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void displayDetails();

    public abstract boolean isExpired();

    @Override
    public String toString() {
        String status = "";
        if (isExpired()) {
            status = " ⚠ EXPIRED";
        }
        return "ID: " + id +
                " | Name: " + name +
                " | Quantity: " + quantity +
                " | Expiry: " + expiryDate +
                status;
    }
}
