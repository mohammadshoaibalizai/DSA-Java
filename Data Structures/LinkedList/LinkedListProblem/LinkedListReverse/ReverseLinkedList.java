/*
 * Recursive Reversal of a Singly Linked List
 * Author: Mohammad Shoaib
 * This program demonstrates:
 * 1. Creating a Linked List
 * 2. Inserting nodes at the end
 * 3. Displaying the Linked List
 * 4. Reversing the Linked List using Recursion
 */

public class ReverseLinkedList {

    // Head points to the first node of the Linked List.
    private Node head;

    // Tail points to the last node of the Linked List.
    private Node tail;

    // Stores the total number of nodes.
    private int size = 0;

    /*
     * Node class:
     * Each Node contains a value and a reference to the next Node.
     */
    private static class Node {

        private int value;

        // Reference to the next Node.
        private Node next;

        // Constructor for creating a Node.
        public Node(int value) {
            this.value = value;
        }
    }


    /*
     * Inserts a new Node at the end of the Linked List.
     */
    public void insertLast(int value) {

        // Create a new Node with the given value.
        Node node = new Node(value);

        // If the Linked List is empty:
        // The new Node becomes both head and tail.
        if (head == null) {

            head = node;
            tail = node;

        } else {

            // Connect the current tail to the new Node.
            tail.next = node;

            // Update tail to point to the new last Node.
            tail = node;
        }

        // Increase the Linked List size.
        size++;
    }


    /*
     * Displays all Nodes from head to the end.
     */
    public void display() {

        // Start traversal from the head.
        Node current = head;

        // Continue until current becomes null.
        while (current != null) {

            // Print the value of the current Node.
            System.out.print(current.value + " -> ");

            // Move to the next Node.
            current = current.next;
        }

        // Print null to indicate the end of the list.
        System.out.println("null");
    }


    /*
     * Reverses the Linked List using Recursion.

     * IMPORTANT:
     * The method must initially be called with head.
     */
    public void reverse(Node node) {

        /*
         * BASE CASE:
         *
         * When node reaches the original tail,
         * the recursion stops going deeper.
         *
         * head is updated to the original tail.
         *
         * return terminates ONLY the current method call.
         * The previous recursive calls are still waiting.
         */
        if (node == tail) {

            head = tail;

            return;
        }


        /*
         * RECURSIVE CALL:
         *
         * Move to the next Node.
         *
         * Call sequence:
         *
         * reverse(10)
         *     reverse(20)
         *         reverse(30)
         *             reverse(40)
         *                 reverse(50)
         *
         * Each call waits at this line until
         * the deeper recursive call returns.
         */
        reverse(node.next);


        /*
         * RECURSION RETURN PHASE:
         *
         * After reverse(node.next) returns,
         * execution continues from the next line.
         *
         * The method does NOT start again from the top.
         *
         * Each waiting call resumes its remaining statements.
         */


        /*
         * STEP 1:
         *
         * Connect the current tail to the current Node.
         *
         * Example:
         * During reverse(40):
         *
         * tail = 50
         * node = 40
         *
         * Therefore:
         * tail.next = node
         * means:
         * 50.next = 40
         */
        tail.next = node;


        /*
         * STEP 2:
         *
         * Update tail to the current Node.
         *
         * Example:
         * tail changes from 50 to 40.
         *
         * In the next recursive return:
         * tail changes from 40 to 30.
         */
        tail = node;


        /*
         * STEP 3:
         *
         * Set the next reference of the current tail to null.
         *
         * This makes the current Node the last Node
         * of the reversed Linked List.
         *
         * Example:
         * 40.next = null
         */
        tail.next = null;
    }


    /*
     * Main method:
     * Creates, displays, and reverses the Linked List.
     */
    public static void main(String[] args) {

        // Create an object of the Linked List.
        ReverseLinkedList list = new ReverseLinkedList();

        /*
         * Insert Nodes at the end.
         *
         * After these method calls:
         *
         * head
         *  |
         *  v
         * 10 -> 20 -> 30 -> 40 -> 50 -> null
         *                              ^
         *                              |
         *                             tail
         */

        list.insertLast(10); // head = tail = 10
        list.insertLast(20); // tail becomes 20
        list.insertLast(30); // tail becomes 30
        list.insertLast(40); // tail becomes 40
        list.insertLast(50); // tail becomes 50


        // Display the original Linked List.
        System.out.print("Original List: ");

        list.display();


        /*
         * START RECURSION:
         *
         * list.head points to the Node containing 10.
         *
         * Call sequence:
         *
         * reverse(10)
         * reverse(20)
         * reverse(30)
         * reverse(40)
         * reverse(50)
         *
         * Base Case:
         * reverse(50)
         *
         * Return sequence:
         *
         * reverse(40)
         * reverse(30)
         * reverse(20)
         * reverse(10)
         *
         * The Nodes are connected in reverse order
         * during the return phase.
         */
        list.reverse(list.head);


        // Display the reversed Linked List.
        System.out.print("Reversed List: ");

        list.display();
    }
}