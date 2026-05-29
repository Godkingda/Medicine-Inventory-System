// Hospital class (OOP Classes requirement)
public class Hospital {

    private String hospitalId;
    private String name;
    private String address;
    private int bedCount;

    public Hospital(String hospitalId, String name, String address, int bedCount) {
        this.hospitalId = hospitalId;
        this.name = name;
        this.address = address;
        this.bedCount = bedCount;
    }

    // Getters
    public String getHospitalId() { return hospitalId; }
    public String getName()       { return name; }
    public String getAddress()    { return address; }
    public int getBedCount()      { return bedCount; }

    // Setters
    public void setAddress(String address)  { this.address = address; }
    public void setBedCount(int bedCount)   { this.bedCount = bedCount; }

    public void displayDetails() {
        System.out.println("Hospital ID: " + hospitalId +
                           " | Name: " + name +
                           " | Address: " + address +
                           " | Beds: " + bedCount);
    }

    @Override
    public String toString() {
        return "Hospital{id='" + hospitalId + "', name='" + name + "', beds=" + bedCount + "}";
    }
}
