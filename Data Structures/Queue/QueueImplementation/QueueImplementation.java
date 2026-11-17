/*
 * Queue Implementation Using Array
 *
 * Definition:
 * A Queue is a linear data structure that follows the FIFO
 * (First In, First Out) principle.
 *
 * This means the first element inserted into the queue
 * will be the first element removed.
 *
 * Real-Life Example:
 * A line of people waiting for a ticket. The person who
 * arrives first gets served first.
 *
 * Queue Operations:
 * 1. enqueue() - Adds an element to the rear of the queue.
 * 2. dequeue() - Removes and returns the front element.
 * 3. peek()    - Returns the front element without removing it.
 * 4. isEmpty() - Checks whether the queue is empty.
 * 5. isFull()  - Checks whether the queue is full.
 * 6. size()    - Returns the number of elements.
 * 7. display() - Displays all queue elements.
 *
 * Time Complexity:
 * enqueue() : O(1)
 * dequeue() : O(1)
 * peek()    : O(1)
 * isEmpty() : O(1)
 * isFull()  : O(1)
 * size()    : O(1)
 * display() : O(n)
 *
 * Space Complexity: O(n)
 *
 * Note:
 * This is a simple linear queue with fixed capacity.
 * Once the rear reaches the last array index, no more
 * elements can be inserted, even if some positions are empty.
 */

public class QueueImplementation {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    // Constructor: Initializes an empty queue with a given capacity.
    public QueueImplementation(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    // Checks whether the queue contains no elements.
    public boolean isEmpty() {
        return rear < front;
    }

    // Checks whether the rear has reached the last array position.
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Adds a new element at the rear of the queue.
    public void enqueue(int value) {

        // Prevents insertion when the queue is full.
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }

        // Moves rear to the next available position.
        rear++;

        // Inserts the new element at the rear.
        queue[rear] = value;
    }

    // Removes and returns the front element from the queue.
    public int dequeue() {

        // Prevents deletion when the queue is empty.
        if (isEmpty()) {
            System.out.println("Queue Underflow!");
            return -1;
        }

        // Stores the front element before removing it.
        int removed = queue[front];

        // Moves front to the next element.
        front++;

        // Resets the queue when all elements are removed.
        if (front > rear) {
            front = 0;
            rear = -1;
        }

        return removed;
    }

    // Returns the front element without removing it.
    public int peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return queue[front];
    }

    // Returns the current number of elements in the queue.
    public int size() {
        return rear - front + 1;
    }

    // Displays all elements from front to rear.
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }

        System.out.println();
    }

    // Main method: Demonstrates the queue operations.
    public static void main(String[] args) {

        // Creates a queue with a capacity of five elements.
        QueueImplementation queue = new QueueImplementation(5);

        // Adds elements to the queue.
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        // Displays the current queue.
        System.out.println("Queue Elements:");
        queue.display();

        // Shows the front element.
        System.out.println("Front Element: " + queue.peek());

        // Removes the front element.
        System.out.println("Removed Element: " + queue.dequeue());
            queue.display();
        // Adds another element.
        queue.enqueue(50);

        // Displays the updated queue.
        System.out.println("Updated Queue:");
        queue.display();

        // Displays the current queue information.
        System.out.println("Queue Size: " + queue.size());
        System.out.println("Is Empty? " + queue.isEmpty());
        System.out.println("Is Full? " + queue.isFull());
    }
}