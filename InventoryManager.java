import java.io.*;

// ============================================================
// LINKED LIST: Inventory stored as a custom singly linked list.
//   head → MedicineNode → MedicineNode → ... → null
//
// SEARCHING: Linear search by name (traverses list node by node).
// SORTING:   Bubble sort on linked list by expiry date.
// ============================================================
public class InventoryManager {

    private MedicineNode head; // first node of the linked list
    private int size;

    public InventoryManager() {
        head = null;
        size = 0;
    }

    // ---- ADD: append new node at end ----
    public void addMedicine(Medicine med) {
        MedicineNode newNode = new MedicineNode(med);
        if (head == null) {
            head = newNode;
        } else {
            MedicineNode current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
        System.out.println("[" + med.getCategory() + "] '" + med.getName() + "' added to inventory.");
    }

    // ---- DISPLAY: traverse and print all nodes ----
    public void displayInventory() {
        if (head == null) { System.out.println("Inventory is empty."); return; }
        System.out.println("\n========= Inventory (" + size + " items) =========");
        MedicineNode current = head;
        int pos = 1;
        while (current != null) {
            System.out.print(pos + ". ");
            current.data.displayDetails();
            current = current.next;
            pos++;
        }
        System.out.println("===========================================");
    }

    // ---- SEARCHING: linear search by name ----
    public Medicine searchMedicine(String name) {
        MedicineNode current = head;
        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(name)) return current.data;
            current = current.next;
        }
        return null;
    }

    // ---- SORTING: bubble sort by expiry date ----
    public void sortByExpiry() {
        if (head == null) { System.out.println("Inventory is empty."); return; }
        boolean swapped;
        do {
            swapped = false;
            MedicineNode curr = head;
            while (curr.next != null) {
                if (curr.data.getExpiryDate().compareTo(curr.next.data.getExpiryDate()) > 0) {
                    Medicine temp  = curr.data;
                    curr.data      = curr.next.data;
                    curr.next.data = temp;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
        System.out.println("Sorted by expiry date:");
        displayInventory();
    }

    // ---- SAVE to file ----
    public void saveInventory() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("inventory.txt"));
            MedicineNode current = head;
            while (current != null) {
                writer.println(current.data.toString());
                current = current.next;
            }
            writer.close();
            System.out.println("Inventory saved.");
        } catch (IOException e) { System.out.println("Error saving inventory."); }
    }

    // ---- LOAD from file ----
    public void loadInventory() {
        try {
            File file = new File("inventory.txt");
            if (!file.exists()) return;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split(",");
                String type    = p[0];
                int    id      = Integer.parseInt(p[1]);
                String name    = p[2];
                int    qty     = Integer.parseInt(p[3]);
                String expiry  = p[4];
                double price   = Double.parseDouble(p[5]);
                String extra   = p.length > 6 ? p[6] : "";
                switch (type) {
                    case "Tablet":
                        addMedicine(new Tablet(id, name, qty, expiry, price, Integer.parseInt(extra)));
                        break;
                    case "Injection":
                        addMedicine(new Injection(id, name, qty, expiry, price, extra));
                        break;
                    case "Syrup":
                        addMedicine(new Syrup(id, name, qty, expiry, price));
                        break;
                }
            }
            reader.close();
            System.out.println("Inventory loaded.");
        } catch (IOException e) { System.out.println("Error loading inventory."); }
    }
}
