import java.util.ArrayList;

public class InventoryManager {

    private ArrayList<Medicine> inventory = new ArrayList<>();

    public void addMedicine(Medicine med) {
        inventory.add(med);
        System.out.println("Medicine added successfully.");
    }

    public void displayInventory() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Medicine med : inventory) {
            med.displayDetails();
        }
    }

    public Medicine searchMedicine(String name) {

        for (Medicine med : inventory) {
            if (med.getName().equalsIgnoreCase(name)) {
                return med;
            }
        }

        return null;
    }
}