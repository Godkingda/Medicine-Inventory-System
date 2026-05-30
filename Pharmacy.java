// ============================================================
// CLASS (Domain): Pharmacy — one of the 5 required classes.
// Represents a pharmacy that stocks and dispenses medicines.
// ENCAPSULATION: private fields, public getters/setters.
// Implements Displayable interface (ABSTRACTION).
// ============================================================
public class Pharmacy implements Displayable {

    private int    pharmacyId;
    private String name;
    private String location;
    private String contactNumber;

    public Pharmacy(int pharmacyId, String name, String location, String contactNumber) {
        this.pharmacyId    = pharmacyId;
        this.name          = name;
        this.location      = location;
        this.contactNumber = contactNumber;
    }

    // Getters
    public int    getPharmacyId()    { return pharmacyId; }
    public String getName()          { return name; }
    public String getLocation()      { return location; }
    public String getContactNumber() { return contactNumber; }

    // Setters
    public void setLocation(String location)          { this.location = location; }
    public void setContactNumber(String contactNumber){ this.contactNumber = contactNumber; }

    @Override
    public void displayDetails() {
        System.out.println("[Pharmacy] ID: " + pharmacyId +
                           " | Name: " + name +
                           " | Location: " + location +
                           " | Contact: " + contactNumber);
    }
}
