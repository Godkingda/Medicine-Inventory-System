// ============================================================
// ARRAY + STACK: BatchStack uses a fixed-size array (Medicine[])
// to implement a stack (LIFO) for batch tracking.
// Works with all Medicine subclasses (Tablet, Injection, Syrup)
// via polymorphism.
// ============================================================
public class BatchStack {

    private Medicine[] stack; // ARRAY
    private int top;
    private int capacity;

    public BatchStack(int capacity) {
        this.capacity = capacity;
        this.stack    = new Medicine[capacity];
        this.top      = -1;
    }

    public boolean isFull()  { return top == capacity - 1; }
    public boolean isEmpty() { return top == -1; }

    public void push(Medicine med) {
        if (isFull()) { System.out.println("Batch stack is full."); return; }
        stack[++top] = med;
        System.out.println("[" + med.getCategory() + "] Batch pushed to stack.");
    }

    public Medicine pop() {
        if (isEmpty()) { System.out.println("No batches in stack."); return null; }
        Medicine removed = stack[top];
        stack[top--] = null;
        if (removed.isExpired()) System.out.println("⚠ WARNING: This batch is expired!");
        return removed;
    }

    public Medicine peek() {
        if (isEmpty()) { System.out.println("Stack is empty."); return null; }
        return stack[top];
    }

    public void displayStack() {
        if (isEmpty()) { System.out.println("Stack is empty."); return; }
        System.out.println("\nBatch Stack (Top → Bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.print((top - i + 1) + ". ");
            stack[i].displayDetails();
        }
    }
}
