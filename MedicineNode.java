// ============================================================
// LINKED LIST: Node class — holds a Medicine and a pointer
// to the next node. Building block of InventoryManager's
// custom singly linked list.
// ============================================================
public class MedicineNode {
    Medicine    data;
    MedicineNode next;

    public MedicineNode(Medicine data) {
        this.data = data;
        this.next = null;
    }
}
