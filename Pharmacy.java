public class Pharmacy {

    private String name;
    private String address;

    public Pharmacy(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void displayDetails() {
        System.out.println("Pharmacy: " + name + " | Address: " + address);
    }
}
