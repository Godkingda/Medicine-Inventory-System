import java.util.Scanner;

// ============================================================
// MAIN: Entry point — wires all components together.
//
// Rubric coverage:
//  ✅ Array        — BatchStack (Medicine[]) + RequestQueue (Request[])
//  ✅ Linked List  — InventoryManager (custom singly linked list)
//  ✅ Stack        — BatchStack (LIFO, push/pop/peek)
//  ✅ Queue        — RequestQueue (FIFO, enqueue/dequeue)
//  ✅ Searching    — Linear search by name in InventoryManager
//  ✅ Sorting      — Bubble sort by expiry date in InventoryManager
//  ✅ Graph        — DistributionGraph (adjacency list)
//  ✅ Classes (5)  — Medicine, InventoryManager, Pharmacy, Supplier, Hospital
//  ✅ Encapsulation— Private fields + getters/setters in all classes
//  ✅ Inheritance  — Tablet, Injection, Syrup extend Medicine
//  ✅ Abstraction  — abstract class Medicine + interface Displayable
// ============================================================
public class Main {

    public static void main(String[] args) {

        InventoryManager manager      = new InventoryManager();
        BatchStack       batchStack   = new BatchStack(100);
        RequestQueue     requestQueue = new RequestQueue(100);
        DistributionGraph graph       = new DistributionGraph();

        // Domain class instances (Pharmacy, Supplier, Hospital)
        Pharmacy pharmacy = new Pharmacy(1, "City Pharmacy", "Main Street", "0300-1234567");
        Supplier supplier = new Supplier(1, "MediCorp Ltd", "Ali Hassan", "ali@medicorp.com", "PharmaBrand");
        Hospital hospital = new Hospital(1, "General Hospital", "Model Town", 500, "042-9999999");

        manager.loadInventory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================================");
        System.out.println("      Medicine Inventory System — DSA + OOP         ");
        System.out.println("====================================================");
        System.out.println("Linked Pharmacy : "); pharmacy.displayDetails();
        System.out.println("Linked Supplier : "); supplier.displayDetails();
        System.out.println("Linked Hospital : "); hospital.displayDetails();
        System.out.println("====================================================");

        while (true) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("-- Inventory (Linked List + Search + Sort) --");
            System.out.println(" 1. Add Tablet");
            System.out.println(" 2. Add Injection");
            System.out.println(" 3. Add Syrup");
            System.out.println(" 4. Display Inventory");
            System.out.println(" 5. Search Medicine by Name");
            System.out.println(" 6. Sort by Expiry Date");
            System.out.println("\n-- Stack (Array-based) --");
            System.out.println(" 7. Push Batch to Stack");
            System.out.println(" 8. Pop Batch from Stack");
            System.out.println(" 9. Display Batch Stack");
            System.out.println("\n-- Queue (Array-based) --");
            System.out.println("10. Add Medicine Request");
            System.out.println("11. Process Next Request");
            System.out.println("12. Display Request Queue");
            System.out.println("\n-- Graph --");
            System.out.println("13. Add Distribution Route");
            System.out.println("14. Display Distribution Network");
            System.out.println("\n-- Domain Classes --");
            System.out.println("15. Display Pharmacy Info");
            System.out.println("16. Display Supplier Info");
            System.out.println("17. Display Hospital Info");
            System.out.println("\n18. Save & Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ---- Add Tablet ----
                case 1: {
                    System.out.print("ID: ");                 int id  = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: ");               String name = scanner.nextLine();
                    System.out.print("Quantity: ");           int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Expiry (YYYY-MM-DD): ");String exp = scanner.nextLine();
                    System.out.print("Price (Rs): ");         double price = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Strength (mg): ");      int mg = scanner.nextInt(); scanner.nextLine();
                    manager.addMedicine(new Tablet(id, name, qty, exp, price, mg));
                    break;
                }

                // ---- Add Injection ----
                case 2: {
                    System.out.print("ID: ");                 int id  = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: ");               String name = scanner.nextLine();
                    System.out.print("Quantity: ");           int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Expiry (YYYY-MM-DD): ");String exp = scanner.nextLine();
                    System.out.print("Price (Rs): ");         double price = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Route (IV/IM/SC): ");   String route = scanner.nextLine();
                    manager.addMedicine(new Injection(id, name, qty, exp, price, route));
                    break;
                }

                // ---- Add Syrup ----
                case 3: {
                    System.out.print("ID: ");                 int id  = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: ");               String name = scanner.nextLine();
                    System.out.print("Quantity: ");           int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Expiry (YYYY-MM-DD): ");String exp = scanner.nextLine();
                    System.out.print("Price (Rs): ");         double price = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Volume (ml): ");        int vol = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Dose per spoon: ");     String dose = scanner.nextLine();
                    manager.addMedicine(new Syrup(id, name, qty, exp, price, vol, dose));
                    break;
                }

                case 4: manager.displayInventory(); break;

                case 5: {
                    System.out.print("Enter medicine name: ");
                    String name = scanner.nextLine();
                    Medicine found = manager.searchMedicine(name);
                    if (found != null) found.displayDetails();
                    else System.out.println("Medicine not found.");
                    break;
                }

                case 6: manager.sortByExpiry(); break;

                // ---- Stack ----
                case 7: {
                    System.out.println("Type: 1=Tablet  2=Injection  3=Syrup");
                    int t = scanner.nextInt(); scanner.nextLine();
                    System.out.print("ID: ");                 int id  = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: ");               String nm = scanner.nextLine();
                    System.out.print("Quantity: ");           int qty = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Expiry (YYYY-MM-DD): ");String ex = scanner.nextLine();
                    System.out.print("Price (Rs): ");         double pr = scanner.nextDouble(); scanner.nextLine();
                    if      (t == 1) { System.out.print("Strength (mg): "); int mg = scanner.nextInt(); scanner.nextLine(); batchStack.push(new Tablet(id, nm, qty, ex, pr, mg)); }
                    else if (t == 2) { System.out.print("Route: "); String ro = scanner.nextLine(); batchStack.push(new Injection(id, nm, qty, ex, pr, ro)); }
                    else             { System.out.print("Volume (ml): "); int vl = scanner.nextInt(); scanner.nextLine(); System.out.print("Dose: "); String ds = scanner.nextLine(); batchStack.push(new Syrup(id, nm, qty, ex, pr, vl, ds)); }
                    break;
                }

                case 8: {
                    Medicine used = batchStack.pop();
                    if (used != null) { System.out.println("Popped batch:"); used.displayDetails(); }
                    break;
                }

                case 9: batchStack.displayStack(); break;

                // ---- Queue ----
                case 10: {
                    System.out.print("Department: ");    String dept = scanner.nextLine();
                    System.out.print("Medicine Name: "); String med  = scanner.nextLine();
                    System.out.print("Quantity: ");      int rqty = scanner.nextInt(); scanner.nextLine();
                    requestQueue.enqueue(new Request(dept, med, rqty));
                    break;
                }

                case 11: {
                    Request req = requestQueue.dequeue();
                    if (req != null) { System.out.println("Processing:"); req.displayDetails(); }
                    break;
                }

                case 12: requestQueue.displayQueue(); break;

                // ---- Graph ----
                case 13: {
                    System.out.print("From location: "); String from = scanner.nextLine();
                    System.out.print("To location: ");   String to   = scanner.nextLine();
                    graph.addRoute(from, to);
                    System.out.println("Route added.");
                    break;
                }

                case 14: graph.displayNetwork(); break;

                // ---- Domain Classes ----
                case 15: pharmacy.displayDetails(); break;
                case 16: supplier.displayDetails(); break;
                case 17: hospital.displayDetails(); break;

                case 18:
                    manager.saveInventory();
                    System.out.println("Goodbye!");
                    return;

                default: System.out.println("Invalid option.");
            }
        }
    }
}
