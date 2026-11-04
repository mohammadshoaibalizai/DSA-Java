/*
 * Find the Middle Node of a Singly Linked List
 *
 * This program demonstrates:
 * 1. Creating a singly linked list.
 * 2. Inserting nodes at the end.
 * 3. Finding the middle node using slow and fast pointers.
 * 4. Returning the middle node of the linked list.
 *
 * Algorithm:
 * Slow and Fast Pointer Technique
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Note:
 * If the list contains an even number of nodes,
 * the second middle node is returned.
 */

public class FindMiddleNode {

    static class LinkedList {

        private Node head;
        private Node tail;
        private int size = 0;

        // Represents a single node in the Linked List.
        private class Node {
            private int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        // Inserts a new node at the end of the Linked List.
        public void insertLast(int value) {

            Node node = new Node(value);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            size++;
        }

        // Finds and returns the middle node of the Linked List.
        public Node findMiddle() {

            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {

                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

        // Returns the value of the middle node.
        public int middleValue() {

            Node middle = findMiddle();

            if (middle == null) {
                throw new IllegalStateException(
                        "The Linked List is empty."
                );
            }

            return middle.value;
        }

        // Displays all elements of the Linked List.
        public void display() {

            Node temp = head;

            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }

            System.out.println("END");
        }
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // Creates a Linked List with an odd number of nodes.
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        list.insertLast(50);

        System.out.println("Linked List:");
        list.display();

        // Finds the middle node.
        System.out.println("Middle Node: " + list.middleValue());

        LinkedList list2 = new LinkedList();

        // Creates a Linked List with an even number of nodes.
        list2.insertLast(5);
        list2.insertLast(10);
        list2.insertLast(15);
        list2.insertLast(20);

        System.out.println("\nSecond Linked List:");
        list2.display();

        System.out.println(
                "Middle Node: " + list2.middleValue()
        );
    }
}