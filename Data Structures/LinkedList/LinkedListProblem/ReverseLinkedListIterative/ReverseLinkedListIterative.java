/*
 * Reverse a Singly Linked List using Iteration.

 * This program reverses a Linked List using three pointers:
 * prev, present, and next.

 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 */

public class ReverseLinkedListIterative {

    // Points to the first node of the Linked List.
    private Node head;

    // Points to the last node of the Linked List.
    private Node tail;

    // Stores the total number of nodes in the Linked List.
    private int size = 0;


    /*
     * Node class:
     * Each node stores a value and a reference to the next node.
     */
    private static class Node {
        private int value;
        // Reference to the next node in the Linked List.
        private Node next;

        // Constructor to create a node with the given value.
        public Node(int value) {
            this.value = value;
        }
    }


    /*
     * Inserts a new node at the end of the Linked List.
     */
    public void insertLast(int value) {

        // Create a new node with the given value.
        Node node = new Node(value);

        // If the Linked List is empty,
        // the new node becomes both head and tail.
        if (head == null) {

            head = node;
            tail = node;

        } else {

            // Connect the current tail to the new node.
            tail.next = node;

            // Update tail to point to the new last node.
            tail = node;
        }

        // Increase the size of the Linked List.
        size++;
    }


    /*
     * Displays all nodes from head to the end of the Linked List.
     */
    public void display() {

        // Start traversal from the first node.
        Node current = head;

        // Traverse the Linked List until current becomes null.
        while (current != null) {

            // Print the value of the current node.
            System.out.print(current.value + " -> ");

            // Move to the next node.
            current = current.next;
        }

        // Print null to indicate the end of the Linked List.
        System.out.println("null");
    }


    /*
     * Reverses the Linked List using an iterative approach.

     * Three pointers are used:
     * prev    : Points to the previous node.
     * present : Points to the current node.
     * next    : Temporarily stores the next node.
     */
    public void reverse() {

        /*
         * BASE CONDITION:
         *
         * If the Linked List contains fewer than two nodes,
         * reversing it is unnecessary.
         *
         * An empty list or a single-node list remains unchanged.
         */
        if (size < 2) {
            return;
        }


        /*
         * STEP 1: INITIALIZE POINTERS
         *
         * prev starts at null because the first node
         * has no previous node.
         *
         * present starts at head because we begin
         * reversing from the first node.
         *
         * next stores the node after present.
         * It is important to save this reference before
         * changing the current node's next pointer.
         */

        Node prev = null;

        Node present = head;

        Node next = present.next;


        /*
         * STEP 2: REVERSE THE LINKS
         *
         * Continue the loop until present becomes null.
         *
         * In each iteration:
         * 1. Reverse the current node's next reference.
         * 2. Move prev one step forward.
         * 3. Move present one step forward.
         * 4. Update next to preserve the upcoming node.
         */
        while (present != null) {


            /*
             * STEP 2.1: REVERSE THE CURRENT LINK
             *
             * Connect the current node to the previous node.
             *
             * Example:
             * present = 20
             * prev = 10
             *
             * present.next = prev
             *
             * This changes:
             * 20 -> 30
             *
             * Into:
             * 20 -> 10
             */
            present.next = prev;


            /*
             * STEP 2.2: MOVE PREV FORWARD
             *
             * prev now points to the current node.
             *
             * Example:
             * prev changes from 10 to 20.
             *
             * This node becomes the previous node
             * for the next iteration.
             */
            prev = present;


            /*
             * STEP 2.3: MOVE PRESENT FORWARD
             *
             * present moves to the node stored in next.
             *
             * Example:
             * present changes from 20 to 30.
             *
             * The next node becomes the current node.
             */
            present = next;


            /*
             * STEP 2.4: UPDATE NEXT
             *
             * Move next one node forward to preserve
             * the upcoming node for the next iteration.
             *
             * Example:
             * next changes from 30 to 40.
             *
             * The null check prevents accessing next.next
             * when next is null.
             */
            if (next != null) {
                next = next.next;
            }
        }


        /*
         * STEP 3: UPDATE HEAD AND TAIL
         *
         * When the loop ends:
         *
         * present = null
         * prev points to the original last node.
         *
         * Therefore, prev becomes the new head.
         *
         * The original head becomes the new tail.
         */
        Node oldHead = head;

        head = prev;

        tail = oldHead;
    }


    /*
     * Main method:
     * Creates a Linked List, displays it,
     * reverses it, and displays the reversed list.
     */
    public static void main(String[] args) {

        // Create a new Linked List object.
        ReverseLinkedListIterative list =
                new ReverseLinkedListIterative();


        /*
         * Insert nodes at the end of the Linked List.
         *
         * Original Linked List:
         *
         * head
         *  |
         *  v
         * 10 -> 20 -> 30 -> 40 -> 50 -> null
         *                              ^
         *                              |
         *                             tail
         */

        list.insertLast(10); // Insert the first node.
        list.insertLast(20); // Insert 20 after 10.
        list.insertLast(30); // Insert 30 after 20.
        list.insertLast(40); // Insert 40 after 30.
        list.insertLast(50); // Insert 50 after 40.


        // Display the original Linked List.
        System.out.print("Original Linked List: ");

        list.display();


        /*
         * Call the reverse method.
         *
         * The links are reversed using the while loop.
         *
         * After reversal:
         *
         * head
         *  |
         *  v
         * 50 -> 40 -> 30 -> 20 -> 10 -> null
         *                              ^
         *                              |
         *                             tail
         */
        list.reverse();


        // Display the reversed Linked List.
        System.out.print("Reversed Linked List: ");

        list.display();
    }
}
