// ============================================================
// ARRAY + QUEUE: RequestQueue uses a fixed-size array (Request[])
// to implement a queue (FIFO) for department medicine requests.
// ============================================================
public class RequestQueue {

    private Request[] queue; // ARRAY
    private int front;
    private int rear;
    private int capacity;

    public RequestQueue(int capacity) {
        this.capacity = capacity;
        this.queue    = new Request[capacity];
        this.front    = 0;
        this.rear     = -1;
    }

    public boolean isEmpty() { return rear < front; }
    public boolean isFull()  { return rear == capacity - 1; }

    public void enqueue(Request req) {
        if (isFull()) { System.out.println("Request queue is full."); return; }
        queue[++rear] = req;
        System.out.println("Request added to queue.");
    }

    public Request dequeue() {
        if (isEmpty()) { System.out.println("No requests in queue."); return null; }
        return queue[front++];
    }

    public void displayQueue() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        System.out.println("\nPending Requests:");
        for (int i = front; i <= rear; i++) {
            System.out.print((i - front + 1) + ". ");
            queue[i].displayDetails();
        }
    }
}
