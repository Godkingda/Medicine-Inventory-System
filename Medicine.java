public class Medicine {

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

    public void displayDetails() {
        System.out.println("ID: " + id +
                " | Name: " + name +
                " | Quantity: " + quantity +
                " | Expiry: " + expiryDate);
    }
}