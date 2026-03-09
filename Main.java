import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();
        manager.loadInventory(); // load saved medicines

        BatchStack batchStack = new BatchStack(100);
        RequestQueue requestQueue = new RequestQueue(100);
        DistributionGraph graph = new DistributionGraph();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Medicine Inventory System Started");

        while (true) {

            System.out.println("\n==== MENU ====");
            System.out.println("1. Add Medicine");
            System.out.println("2. Display Inventory");
            System.out.println("3. Search Medicine");
            System.out.println("4. Sort Medicines By Expiry Date");

            System.out.println("\n--- Stack Operations ---");
            System.out.println("5. Add Batch (Push)");
            System.out.println("6. Use Batch (Pop)");
            System.out.println("7. Display Batch Stack");

            System.out.println("\n--- Queue Operations ---");
            System.out.println("8. Add Medicine Request");
            System.out.println("9. Process Request");
            System.out.println("10. Display Request Queue");

            System.out.println("\n--- Graph Operations ---");
            System.out.println("11. Add Distribution Route");
            System.out.println("12. Display Distribution Network");

            System.out.println("\n13. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expiry = scanner.nextLine();

                    Medicine med = new Medicine(id, name, qty, expiry);
                    manager.addMedicine(med);

                    break;

                case 2:
                    manager.displayInventory();
                    break;

                case 3:

                    System.out.print("Enter medicine name: ");
                    String search = scanner.nextLine();

                    Medicine result = manager.searchMedicine(search);

                    if (result != null) {
                        result.displayDetails();
                    } else {
                        System.out.println("Medicine not found.");
                    }

                    break;

                case 4:
                    manager.sortByExpiry();
                    break;

                case 5:

                    System.out.print("Enter ID: ");
                    int bid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String bname = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int bqty = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String bexp = scanner.nextLine();

                    Medicine batch = new Medicine(bid, bname, bqty, bexp);
                    batchStack.push(batch);

                    break;

                case 6:

                    Medicine usedBatch = batchStack.pop();

                    if (usedBatch != null) {
                        System.out.println("Using batch:");
                        usedBatch.displayDetails();
                    }

                    break;

                case 7:
                    batchStack.displayStack();
                    break;

                case 8:

                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();

                    System.out.print("Enter Medicine Name: ");
                    String medName = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int reqQty = scanner.nextInt();
                    scanner.nextLine();

                    Request req = new Request(department, medName, reqQty);
                    requestQueue.enqueue(req);

                    break;

                case 9:

                    Request processed = requestQueue.dequeue();

                    if (processed != null) {
                        System.out.println("Processing request:");
                        processed.displayRequest();
                    }

                    break;

                case 10:
                    requestQueue.displayQueue();
                    break;

                case 11:

                    System.out.print("Enter starting location: ");
                    String from = scanner.nextLine();

                    System.out.print("Enter destination location: ");
                    String to = scanner.nextLine();

                    graph.addRoute(from, to);

                    System.out.println("Route added.");
                    break;

                case 12:
                    graph.displayNetwork();
                    break;

                case 13:

                    manager.saveInventory(); 
                    System.out.println("Inventory saved.");
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}