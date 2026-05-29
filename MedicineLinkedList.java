// LinkedList implementation for dynamic medicine stock records (DSA requirement)
public class MedicineLinkedList {

    // Inner node class
    private static class Node {
        Medicine data;
        Node next;

        Node(Medicine data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MedicineLinkedList() {
        head = null;
        size = 0;
    }

    // Add medicine to the end of the list
    public void addMedicine(Medicine med) {
        Node newNode = new Node(med);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("[LinkedList] Stock record added: " + med.getName());
    }

    // Remove medicine by ID
    public boolean removeMedicine(int id) {
        if (head == null) return false;

        if (head.data.getId() == id) {
            head = head.next;
            size--;
            System.out.println("[LinkedList] Stock record removed for ID: " + id);
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getId() == id) {
                current.next = current.next.next;
                size--;
                System.out.println("[LinkedList] Stock record removed for ID: " + id);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Find medicine by ID
    public Medicine findById(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // Display all stock records
    public void displayStockRecords() {
        if (head == null) {
            System.out.println("[LinkedList] No stock records.");
            return;
        }
        System.out.println("=== Dynamic Stock Records (LinkedList) ===");
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.data);
            current = current.next;
            index++;
        }
        System.out.println("Total records: " + size);
    }

    public int getSize() { return size; }
}
