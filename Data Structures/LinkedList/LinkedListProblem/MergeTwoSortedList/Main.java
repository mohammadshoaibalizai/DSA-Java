//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
 * Merge Two Sorted Linked Lists
 * This program demonstrates:
 * 1. Creating two sorted singly linked lists.
 * 2. Merging two sorted linked lists into one sorted list.
 * 3. Comparing node values.
 * 4. Traversing linked lists.
 * 5. Maintaining head, tail, and size references.

 * Note:
 * Both input linked lists must be sorted in ascending order.
 * Duplicate values are allowed.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 */
public class Main {

        // Represents a singly linked list.
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

            // Displays all elements of the Linked List.
            public void display() {

                Node temp = head;

                while (temp != null) {
                    System.out.print(temp.value + " -> ");
                    temp = temp.next;
                }

                System.out.println("END");
            }

            // Returns the total number of nodes.
            public int getSize() {
                return size;
            }

            // Merges two sorted Linked Lists into one sorted Linked List.
             public static LinkedList mergeSorted(LinkedList first, LinkedList second)
             {
                LinkedList merged = new LinkedList();
                Node firstNode = first.head;
                Node secondNode = second.head;

                // Compares nodes from both lists.
                while (firstNode != null && secondNode != null) {

                    if (firstNode.value <= secondNode.value) {

                        merged.insertLast(firstNode.value);
                        firstNode = firstNode.next;

                    } else {

                        merged.insertLast(secondNode.value);
                        secondNode = secondNode.next;
                    }
                }

                // Adds remaining nodes from the first list.
                while (firstNode != null) {

                    merged.insertLast(firstNode.value);
                    firstNode = firstNode.next;
                }
                // Adds remaining nodes from the second list.
                while (secondNode != null) {

                    merged.insertLast(secondNode.value);
                    secondNode = secondNode.next;
                }

                return merged;
            }
        }

        public static void main(String[] args) {

            // Creates the first sorted Linked List.
            LinkedList first = new LinkedList();
            first.insertLast(1);
            first.insertLast(3);
            first.insertLast(5);
            first.insertLast(7);

            // Creates the second sorted Linked List.
            LinkedList second = new LinkedList();
            second.insertLast(2);
            second.insertLast(4);
            second.insertLast(6);
            second.insertLast(8);

            System.out.println("First Linked List:");
            first.display();

            System.out.println("Second Linked List:");
            second.display();

            // Merges both sorted Linked Lists.
            LinkedList merged =
                    LinkedList.mergeSorted(first, second);
            System.out.println("Merged Sorted Linked List:");
            merged.display();
            System.out.println("Merged List Size: " + merged.getSize());
        }
}
