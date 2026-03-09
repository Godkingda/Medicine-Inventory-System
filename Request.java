public class Request {

    private String department;
    private String medicineName;
    private int quantity;

    public Request(String department, String medicineName, int quantity) {
        this.department = department;
        this.medicineName = medicineName;
        this.quantity = quantity;
    }

    public void displayRequest() {

        System.out.println(
            "Department: " + department +
            " | Medicine: " + medicineName +
            " | Quantity: " + quantity
        );
    }
}