public class BatchStack {

    private Medicine[] stack;
    private int top;
    private int capacity;

    // Constructor
    public BatchStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Medicine[capacity];
        this.top = -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Push operation (add batch)
    public void push(Medicine med) {

        if (isFull()) {
            System.out.println("Batch stack is full.");
            return;
        }

        top++;
        stack[top] = med;

        System.out.println("Batch added to stack.");
    }

    // Pop operation (remove batch)
    public Medicine pop() {

        if (isEmpty()) {
            System.out.println("No batches available.");
            return null;
        }

        Medicine removed = stack[top];
        stack[top] = null;   // helps garbage collection
        top--;

        // ⭐ Smart Stack Warning
        if (removed.isExpired()) {
            System.out.println("⚠ WARNING: This batch is expired!");
        }

        return removed;
    }

    // Peek top batch
    public Medicine peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }

        return stack[top];
    }

    // Display stack
    public void displayStack() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\nBatch Stack (Top → Bottom):");

        for (int i = top; i >= 0; i--) {
            stack[i].displayDetails();
        }
    }
}