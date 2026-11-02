
    /*
     * Cycle Detection in a Singly Linked List
     *
     * This program demonstrates:
     * 1. Creating a singly linked list.
     * 2. Detecting a cycle in the linked list.
     * 3. Using slow and fast pointers.
     * 4. Returning true if a cycle exists.
     * 5. Returning false if no cycle exists.
     *
     * Algorithm:
     * Floyd's Cycle Detection Algorithm
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public class CycleDetection {

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

            // Creates a cycle by connecting the tail to a node at the given index.
            public void createCycle(int index) {

                if (head == null || index < 0 || index >= size) {
                    return;
                }

                Node temp = head;

                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }

                tail.next = temp;
            }

            // Checks whether a cycle exists in the Linked List.
            public boolean hasCycle() {

                Node slow = head;
                Node fast = head;

                while (fast != null && fast.next != null) {

                    slow = slow.next;
                    fast = fast.next.next;

                    // If both pointers meet, a cycle exists.
                    if (slow == fast) {
                        return true;
                    }
                }

                // If fast reaches null, no cycle exists.
                return false;
            }
        }

        public static void main(String[] args) {

            LinkedList list = new LinkedList();

            // Creates a Linked List.
            list.insertLast(10);
            list.insertLast(20);
            list.insertLast(30);
            list.insertLast(40);
            list.insertLast(50);

            // Creates a cycle in the Linked List.
            list.createCycle(2);

            // Detects whether the Linked List contains a cycle.
            System.out.println("Cycle Exists: " + list.hasCycle());

            LinkedList list2 = new LinkedList();

            // Creates a Linked List without a cycle.
            list2.insertLast(1);
            list2.insertLast(2);
            list2.insertLast(3);
            list2.insertLast(4);

            System.out.println("Cycle Exists: " + list2.hasCycle());
        }
    }
