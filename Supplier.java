// Supplier class (OOP Classes requirement)
public class Supplier {

    private String supplierId;
    private String name;
    private String contactEmail;
    private String medicineSupplied; // Main type of medicine supplied

    public Supplier(String supplierId, String name, String contactEmail, String medicineSupplied) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactEmail = contactEmail;
        this.medicineSupplied = medicineSupplied;
    }

    // Getters
    public String getSupplierId()       { return supplierId; }
    public String getName()             { return name; }
    public String getContactEmail()     { return contactEmail; }
    public String getMedicineSupplied() { return medicineSupplied; }

    // Setters
    public void setContactEmail(String contactEmail)     { this.contactEmail = contactEmail; }
    public void setMedicineSupplied(String med)          { this.medicineSupplied = med; }

    public void displayDetails() {
        System.out.println("Supplier ID: " + supplierId +
                           " | Name: " + name +
                           " | Email: " + contactEmail +
                           " | Supplies: " + medicineSupplied);
    }

    @Override
    public String toString() {
        return "Supplier{id='" + supplierId + "', name='" + name + "', supplies='" + medicineSupplied + "'}";
    }
}
