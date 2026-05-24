public class Supplier {

    private String name;
    private String contactNumber;

    public Supplier(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void displayDetails() {
        System.out.println("Supplier: " + name + " | Contact: " + contactNumber);
    }
}
