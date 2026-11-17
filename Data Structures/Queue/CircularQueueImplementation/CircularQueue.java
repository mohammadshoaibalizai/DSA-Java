/*
 * Circular Queue Implementation Using Array
 *
 * Definition:
 * A Circular Queue is a linear data structure that follows
 * the FIFO (First In, First Out) principle.
 *
 * Unlike a simple linear queue, the last position of a
 * circular queue is connected to the first position.
 * This allows the queue to reuse empty spaces created
 * after removing elements.
 *
 * Circular Queue Operations:
 * 1. enqueue() - Adds an element to the rear of the queue.
 * 2. dequeue() - Removes and returns the front element.
 * 3. peek()    - Returns the front element without removing it.
 * 4. isEmpty() - Checks whether the queue is empty.
 * 5. isFull()  - Checks whether the queue is full.
 * 6. size()    - Returns the current number of elements.
 * 7. display() - Displays all elements from front to rear.
 *
 * Important Formula:
 * (index + 1) % capacity
 *
 * This formula moves an index forward circularly.
 * When the index reaches the last position, it returns to 0.
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
 */

public class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor: Initializes an empty circular queue.
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Checks whether the queue contains no elements.
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks whether the queue has reached its maximum capacity.
    public boolean isFull() {
        return size == capacity;
    }

    // Adds a new element to the rear of the circular queue.
    public void enqueue(int value) {

        // Prevents insertion when the queue is full.
        if (isFull()) {
            System.out.println("Queue Overflow!");
            return;
        }

        // Moves rear forward circularly.
        rear = (rear + 1) % capacity;

        // Inserts the new element at the rear position.
        queue[rear] = value;

        // Increases the number of elements.
        size++;
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

        // Moves front forward circularly.
        front = (front + 1) % capacity;

        // Decreases the number of elements.
        size--;

        // Resets front and rear when the queue becomes empty.
        if (size == 0) {
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
        return size;
    }

    // Displays all elements from front to rear.
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue Elements: ");

        // Traverses the queue using circular indexing.
        for (int i = 0; i < size; i++) {

            int index = (front + i) % capacity;

            System.out.print(queue[index] + " ");
        }

        System.out.println();
    }

    // Main method: Demonstrates circular queue operations.
    public static void main(String[] args) {

        // Creates a circular queue with a capacity of five.
        CircularQueue queue = new CircularQueue(5);

        // Inserts elements into the queue.
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();

        // Removes two elements from the front.
        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Removed: " + queue.dequeue());

        // Inserts new elements into the available positions.

        System.out.println("Inserting new element 60 and 70 ");
        queue.enqueue(60);
        queue.enqueue(70);

        // Displays the updated circular queue.
        queue.display();

        // Displays queue information.
        System.out.println("Front Element: " + queue.peek());
        System.out.println("Queue Size: " + queue.size());
        System.out.println("Is Empty? " + queue.isEmpty());
        System.out.println("Is Full? " + queue.isFull());
    }
}