import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;

public class InventoryManager {

    private ArrayList<Medicine> inventory = new ArrayList<>();

    // LinkedList for dynamic stock record tracking (DSA requirement)
    private MedicineLinkedList stockRecords = new MedicineLinkedList();

    // Add medicine to both ArrayList inventory and LinkedList stock records
    public void addMedicine(Medicine med) {
        inventory.add(med);
        stockRecords.addMedicine(med); // Keep LinkedList in sync
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

    // Search by name (case-insensitive)
    public Medicine searchMedicine(String name) {
        for (Medicine med : inventory) {
            if (med.getName().equalsIgnoreCase(name)) {
                return med;
            }
        }
        return null;
    }

    // Search by category (DSA + case study requirement)
    public ArrayList<Medicine> searchByCategory(String category) {
        ArrayList<Medicine> results = new ArrayList<>();
        for (Medicine med : inventory) {
            if (med.getCategory().equalsIgnoreCase(category)) {
                results.add(med);
            }
        }
        return results;
    }

    // Display the LinkedList stock records separately
    public void displayStockRecords() {
        stockRecords.displayStockRecords();
    }

    // Remove from both structures by ID
    public boolean removeMedicine(int id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId() == id) {
                inventory.remove(i);
                stockRecords.removeMedicine(id);
                System.out.println("Medicine removed successfully.");
                return true;
            }
        }
        System.out.println("Medicine with ID " + id + " not found.");
        return false;
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
                // Format: type,id,name,quantity,expiryDate,category,extraInfo
                String type = med.getClass().getSimpleName();
                String extra = med.getExtraInfo();
                writer.println(type + "," +
                               med.getId() + "," +
                               med.getName() + "," +
                               med.getQuantity() + "," +
                               med.getExpiryDate() + "," +
                               med.getCategory() + "," +
                               extra);
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
            if (!file.exists()) return;

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 7);
                if (parts.length < 6) continue;

                String type   = parts[0];
                int id        = Integer.parseInt(parts[1]);
                String name   = parts[2];
                int qty       = Integer.parseInt(parts[3]);
                String expiry = parts[4];
                String extra  = parts.length == 7 ? parts[6] : "";

                Medicine med;
                switch (type) {
                    case "Tablet":
                        int dosage = extra.isEmpty() ? 0 : Integer.parseInt(extra.replace("mg", "").replace("Dosage: ", "").trim());
                        med = new Tablet(id, name, qty, expiry, dosage);
                        break;
                    case "Injection":
                        String route = extra.isEmpty() ? "IV" : extra.replace("Route: ", "").trim();
                        med = new Injection(id, name, qty, expiry, route);
                        break;
                    case "Syrup":
                        int vol = extra.isEmpty() ? 0 : Integer.parseInt(extra.replace("ml", "").replace("Volume: ", "").trim());
                        med = new Syrup(id, name, qty, expiry, vol);
                        break;
                    default:
                        med = new Medicine(id, name, qty, expiry);
                        break;
                }
                inventory.add(med);
                stockRecords.addMedicine(med);
            }
            reader.close();
            System.out.println("Inventory loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading inventory.");
        }
    }
}
