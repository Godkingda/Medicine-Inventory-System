import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Medicine Inventory System Started");

        while (true) {

            System.out.println("\n1. Add Medicine");
            System.out.println("2. Display Inventory");
            System.out.println("3. Search Medicine");
            System.out.println("4. Exit");

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

                    System.out.print("Enter Expiry Date: ");
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
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}