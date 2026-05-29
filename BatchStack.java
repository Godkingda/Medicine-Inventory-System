public class BatchStack {

    private Medicine[] stack;
    private int top;
    private int capacity;

    public BatchStack(int capacity) {
        this.capacity = capacity;
        this.stack = new Medicine[capacity];
        this.top = -1;
    }

    public boolean isFull()  { return top == capacity - 1; }
    public boolean isEmpty() { return top == -1; }

    public void push(Medicine med) {
        if (isFull()) {
            System.out.println("Batch stack is full.");
            return;
        }
        top++;
        stack[top] = med;
        System.out.println("Batch added to stack.");
    }

    public Medicine pop() {
        if (isEmpty()) {
            System.out.println("No batches available.");
            return null;
        }
        Medicine removed = stack[top];
        stack[top] = null;
        top--;
        if (removed.isExpired()) {
            System.out.println("⚠ WARNING: This batch is expired!");
        }
        return removed;
    }

    public Medicine peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stack[top];
    }

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
