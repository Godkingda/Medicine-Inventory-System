import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

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

    public void sortByExpiry() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        Collections.sort(inventory, new Comparator<Medicine>() {
            public int compare(Medicine m1, Medicine m2) {
                return m1.getExpiryDate().compareTo(m2.getExpiryDate());
            }
        });

        System.out.println("Medicines sorted by expiry date:");
        displayInventory();
    }

    // =============================
    // SAVE INVENTORY TO FILE
    // =============================
    public void saveInventory() {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("inventory.txt"));

            for (Medicine med : inventory) {
                writer.println(
                        med.getId() + "," +
                        med.getName() + "," +
                        med.getQuantity() + "," +
                        med.getExpiryDate()
                );
            }

            writer.close();
            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }

    // =============================
    // LOAD INVENTORY FROM FILE
    // =============================
    public void loadInventory() {

        try {

            File file = new File("inventory.txt");

            if (!file.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int qty = Integer.parseInt(parts[2]);
                String expiry = parts[3];

                inventory.add(new Medicine(id, name, qty, expiry));
            }

            reader.close();
            System.out.println("Inventory loaded from file.");

        } catch (IOException e) {
            System.out.println("Error loading inventory.");
        }
    }
}