// Circular Queue for medicine requests — fixes the linear array limitation
public class RequestQueue {

    private Request[] queue;
    private int front, rear, size, capacity;

    public RequestQueue(int capacity) {
        this.capacity = capacity;
        queue = new Request[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enqueue(Request request) {
        if (size == capacity) {
            System.out.println("Request queue is full.");
            return false;
        }
        rear = (rear + 1) % capacity; // Circular wrap
        queue[rear] = request;
        size++;
        System.out.println("Request added to queue.");
        return true;
    }

    public Request dequeue() {
        if (size == 0) {
            System.out.println("No pending requests.");
            return null;
        }
        Request req = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity; // Circular wrap
        size--;
        return req;
    }

    public void displayQueue() {
        if (size == 0) {
            System.out.println("Request queue is empty.");
            return;
        }
        System.out.println("=== Pending Requests ===");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.println((i + 1) + ". ");
            queue[index].displayRequest();
        }
    }

    public int getSize() { return size; }
    public boolean isEmpty() { return size == 0; }
}
