// ============================================================
// CLASS: Request — base class for department medicine requests.
// Implements Displayable (ABSTRACTION via interface).
// ============================================================
public class Request implements Displayable {

    private String department;
    private String medicineName;
    private int    quantity;

    public Request(String department, String medicineName, int quantity) {
        this.department   = department;
        this.medicineName = medicineName;
        this.quantity     = quantity;
    }

    public String getDepartment()   { return department; }
    public String getMedicineName() { return medicineName; }
    public int    getQuantity()     { return quantity; }

    @Override
    public void displayDetails() {
        System.out.println("Dept: " + department +
                           " | Medicine: " + medicineName +
                           " | Qty: " + quantity);
    }

    // Keep backward compatibility
    public void displayRequest() { displayDetails(); }
}
