// Pharmacy class (OOP Classes requirement)
public class Pharmacy {

    private String name;
    private String location;
    private String contactNumber;

    public Pharmacy(String name, String location, String contactNumber) {
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
    }

    // Getters
    public String getName()          { return name; }
    public String getLocation()      { return location; }
    public String getContactNumber() { return contactNumber; }

    // Setters
    public void setName(String name)                   { this.name = name; }
    public void setLocation(String location)           { this.location = location; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public void displayDetails() {
        System.out.println("Pharmacy: " + name +
                           " | Location: " + location +
                           " | Contact: " + contactNumber);
    }

    @Override
    public String toString() {
        return "Pharmacy{name='" + name + "', location='" + location + "', contact='" + contactNumber + "'}";
    }
}
