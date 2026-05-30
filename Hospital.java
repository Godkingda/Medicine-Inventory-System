// ============================================================
// CLASS (Domain): Hospital — one of the 5 required classes.
// Represents a hospital that requests and uses medicines.
// ENCAPSULATION: private fields, public getters/setters.
// Implements Displayable interface (ABSTRACTION).
// ============================================================
public class Hospital implements Displayable {

    private int    hospitalId;
    private String hospitalName;
    private String address;
    private int    totalBeds;
    private String contactNumber;

    public Hospital(int hospitalId, String hospitalName, String address, int totalBeds, String contactNumber) {
        this.hospitalId    = hospitalId;
        this.hospitalName  = hospitalName;
        this.address       = address;
        this.totalBeds     = totalBeds;
        this.contactNumber = contactNumber;
    }

    // Getters
    public int    getHospitalId()    { return hospitalId; }
    public String getHospitalName()  { return hospitalName; }
    public String getAddress()       { return address; }
    public int    getTotalBeds()     { return totalBeds; }
    public String getContactNumber() { return contactNumber; }

    // Setters
    public void setAddress(String address)       { this.address = address; }
    public void setTotalBeds(int totalBeds)      { this.totalBeds = totalBeds; }
    public void setContactNumber(String contact) { this.contactNumber = contact; }

    @Override
    public void displayDetails() {
        System.out.println("[Hospital] ID: " + hospitalId +
                           " | Name: " + hospitalName +
                           " | Address: " + address +
                           " | Beds: " + totalBeds +
                           " | Contact: " + contactNumber);
    }
}
