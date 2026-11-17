/*
 * Stack Implementation Using Array
 *
 * Description:
 * This program implements a Stack data structure using an array.
 * A Stack follows the LIFO (Last In, First Out) principle,
 * which means the last element inserted is the first one removed.
 *
 * Supported Operations:
 * 1. push()    - Adds an element to the top of the stack.
 * 2. pop()     - Removes and returns the top element.
 * 3. peek()    - Returns the top element without removing it.
 * 4. isEmpty() - Checks whether the stack is empty.
 * 5. isFull()  - Checks whether the stack is full.
 * 6. size()    - Returns the number of elements.
 * 7. display() - Displays all stack elements.
 *
 * Time Complexity:
 * push()    : O(1)
 * pop()     : O(1)
 * peek()    : O(1)
 * isEmpty() : O(1)
 * isFull()  : O(1)
 * size()    : O(1)
 * display() : O(n)
 *
 * Space Complexity: O(n)
 *
 * Note:
 * This implementation has a fixed capacity.
 */

public class StackImplementation {

    private int[] stack;
    private int top;
    private int capacity;

    // Constructor: Initializes the stack with a given capacity.
    public StackImplementation(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Checks whether the stack contains no elements.
    public boolean isEmpty() {
        return top == -1;
    }

    // Checks whether the stack has reached its maximum capacity.
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Adds a new element to the top of the stack.
    public void push(int value) {

        // Prevents adding an element when the stack is full.
        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        }

        // Moves the top pointer to the next available position.
        top++;

        // Stores the new element at the top position.
        stack[top] = value;
    }

    // Removes and returns the top element from the stack.
    public int pop() {

        // Prevents removing an element from an empty stack.
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }

        // Saves the top element before removing it.
        int removed = stack[top];

        // Moves the top pointer one position backward.
        top--;

        return removed;
    }

    // Returns the top element without removing it.
    public int peek() {

        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return stack[top];
    }

    // Returns the current number of elements in the stack.
    public int size() {
        return top + 1;
    }

    // Displays all elements from top to bottom.
    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    // Main method: Demonstrates the stack operations.
    public static void main(String[] args) {

        // Creates a stack with a capacity of five elements.
        StackImplementation stack = new StackImplementation(5);

        // Adds elements to the stack.
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Displays the current stack.
        stack.display();

        // Shows the element currently at the top.
        System.out.println("Top element: " + stack.peek());

        // Removes and displays the top element.
        System.out.println("Removed: " + stack.pop());

        // Adds another element after the pop operation.
        stack.push(50);

        // Displays the updated stack.
        System.out.println("Updated Stack:");
        stack.display();

        // Displays the current stack information.
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is empty? " + stack.isEmpty());
        System.out.println("Is full? " + stack.isFull());
    }
}