import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();
        manager.loadInventory();

        BatchStack batchStack = new BatchStack(100);
        RequestQueue requestQueue = new RequestQueue(100);
        DistributionGraph graph = new DistributionGraph();

        // OOP demo: instantiate Pharmacy, Supplier, Hospital objects
        Pharmacy pharmacy = new Pharmacy("City Pharmacy", "Delhi", "011-12345678");
        Supplier supplier = new Supplier("SUP001", "MedSupply Co.", "medsupply@email.com", "Tablets");
        Hospital hospital = new Hospital("HSP001", "Apollo Hospital", "New Delhi", 500);

        Scanner scanner = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("   Medicine Inventory System");
        System.out.println("===================================");
        System.out.println("Pharmacy : " + pharmacy.getName() + " (" + pharmacy.getLocation() + ")");
        System.out.println("Supplier : " + supplier.getName());
        System.out.println("Hospital : " + hospital.getName());
        System.out.println("===================================");

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("--- Inventory ---");
            System.out.println("1.  Add Medicine (General)");
            System.out.println("2.  Add Tablet");
            System.out.println("3.  Add Injection");
            System.out.println("4.  Add Syrup");
            System.out.println("5.  Display Inventory");
            System.out.println("6.  Search by Name");
            System.out.println("7.  Search by Category");
            System.out.println("8.  Sort by Expiry Date");
            System.out.println("9.  Remove Medicine");
            System.out.println("10. Display Stock Records (LinkedList)");

            System.out.println("\n--- Stack Operations ---");
            System.out.println("11. Add Batch (Push)");
            System.out.println("12. Use Batch (Pop)");
            System.out.println("13. Display Batch Stack");

            System.out.println("\n--- Queue Operations ---");
            System.out.println("14. Add Medicine Request");
            System.out.println("15. Process Request");
            System.out.println("16. Display Request Queue");

            System.out.println("\n--- Graph Operations ---");
            System.out.println("17. Add Distribution Route");
            System.out.println("18. Display Distribution Network");

            System.out.println("\n--- OOP Info ---");
            System.out.println("19. Display Pharmacy/Supplier/Hospital Info");

            System.out.println("\n0.  Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ---- General medicine ----
                case 1: {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiry = scanner.nextLine();
                    manager.addMedicine(new Medicine(id, name, qty, expiry));
                    break;
                }

                // ---- Tablet ----
                case 2: {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiry = scanner.nextLine();
                    System.out.print("Enter Dosage (mg): ");
                    int dosage = scanner.nextInt(); scanner.nextLine();
                    manager.addMedicine(new Tablet(id, name, qty, expiry, dosage));
                    break;
                }

                // ---- Injection ----
                case 3: {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiry = scanner.nextLine();
                    System.out.print("Enter Route (e.g. IV, IM, SC): ");
                    String route = scanner.nextLine();
                    manager.addMedicine(new Injection(id, name, qty, expiry, route));
                    break;
                }

                // ---- Syrup ----
                case 4: {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiry = scanner.nextLine();
                    System.out.print("Enter Volume (ml): ");
                    int vol = scanner.nextInt(); scanner.nextLine();
                    manager.addMedicine(new Syrup(id, name, qty, expiry, vol));
                    break;
                }

                case 5:
                    manager.displayInventory();
                    break;

                // ---- Search by name ----
                case 6: {
                    System.out.print("Enter medicine name: ");
                    String search = scanner.nextLine();
                    Medicine result = manager.searchMedicine(search);
                    if (result != null) {
                        result.displayDetails();
                    } else {
                        System.out.println("Medicine not found.");
                    }
                    break;
                }

                // ---- Search by category ----
                case 7: {
                    System.out.println("Categories: General, Tablet, Injection, Syrup");
                    System.out.print("Enter category: ");
                    String cat = scanner.nextLine();
                    ArrayList<Medicine> catResults = manager.searchByCategory(cat);
                    if (catResults.isEmpty()) {
                        System.out.println("No medicines found in category: " + cat);
                    } else {
                        System.out.println("Found " + catResults.size() + " medicine(s):");
                        for (Medicine m : catResults) m.displayDetails();
                    }
                    break;
                }

                case 8:
                    manager.sortByExpiry();
                    break;

                // ---- Remove medicine ----
                case 9: {
                    System.out.print("Enter ID to remove: ");
                    int removeId = scanner.nextInt(); scanner.nextLine();
                    manager.removeMedicine(removeId);
                    break;
                }

                // ---- LinkedList stock records ----
                case 10:
                    manager.displayStockRecords();
                    break;

                // ---- Stack operations ----
                case 11: {
                    System.out.print("Enter ID: ");
                    int bid = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String bname = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int bqty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String bexp = scanner.nextLine();
                    batchStack.push(new Medicine(bid, bname, bqty, bexp));
                    break;
                }

                case 12: {
                    Medicine usedBatch = batchStack.pop();
                    if (usedBatch != null) {
                        System.out.println("Using batch:");
                        usedBatch.displayDetails();
                    }
                    break;
                }

                case 13:
                    batchStack.displayStack();
                    break;

                // ---- Queue operations ----
                case 14: {
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Medicine Name: ");
                    String medName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int reqQty = scanner.nextInt(); scanner.nextLine();
                    requestQueue.enqueue(new Request(department, medName, reqQty));
                    break;
                }

                case 15: {
                    Request processed = requestQueue.dequeue();
                    if (processed != null) {
                        System.out.println("Processing request:");
                        processed.displayRequest();
                    }
                    break;
                }

                case 16:
                    requestQueue.displayQueue();
                    break;

                // ---- Graph operations ----
                case 17: {
                    System.out.print("Enter starting location: ");
                    String from = scanner.nextLine();
                    System.out.print("Enter destination location: ");
                    String to = scanner.nextLine();
                    graph.addRoute(from, to);
                    System.out.println("Route added.");
                    break;
                }

                case 18:
                    graph.displayNetwork();
                    break;

                // ---- OOP Info ----
                case 19:
                    System.out.println("\n=== OOP Entities ===");
                    pharmacy.displayDetails();
                    supplier.displayDetails();
                    hospital.displayDetails();
                    break;

                // ---- Exit ----
                case 0:
                    manager.saveInventory();
                    System.out.println("Inventory saved. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
