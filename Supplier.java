// ============================================================
// CLASS (Domain): Supplier — one of the 5 required classes.
// Represents a medicine supplier/vendor.
// ENCAPSULATION: private fields, public getters/setters.
// Implements Displayable interface (ABSTRACTION).
// ============================================================
public class Supplier implements Displayable {

    private int    supplierId;
    private String companyName;
    private String contactPerson;
    private String email;
    private String medicineBrand; // brand they supply

    public Supplier(int supplierId, String companyName, String contactPerson, String email, String medicineBrand) {
        this.supplierId    = supplierId;
        this.companyName   = companyName;
        this.contactPerson = contactPerson;
        this.email         = email;
        this.medicineBrand = medicineBrand;
    }

    // Getters
    public int    getSupplierId()    { return supplierId; }
    public String getCompanyName()   { return companyName; }
    public String getContactPerson() { return contactPerson; }
    public String getEmail()         { return email; }
    public String getMedicineBrand() { return medicineBrand; }

    // Setters
    public void setEmail(String email)               { this.email = email; }
    public void setMedicineBrand(String medicineBrand){ this.medicineBrand = medicineBrand; }

    @Override
    public void displayDetails() {
        System.out.println("[Supplier] ID: " + supplierId +
                           " | Company: " + companyName +
                           " | Contact: " + contactPerson +
                           " | Email: " + email +
                           " | Brand: " + medicineBrand);
    }
}
