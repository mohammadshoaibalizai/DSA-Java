
    /*
     * Length of Cycle in a Singly Linked List
     *
     * This program demonstrates:
     * 1. Creating a singly linked list.
     * 2. Creating a cycle in the linked list.
     * 3. Detecting a cycle using slow and fast pointers.
     * 4. Calculating the number of nodes inside the cycle.
     * 5. Returning 0 if no cycle exists.
     *
     * Algorithm:
     * Floyd's Cycle Detection Algorithm
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public class LengthOfCycle {
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

            // Returns the number of nodes inside the cycle.
            public int lengthOfCycle() {

                Node slow = head;
                Node fast = head;

                // Detects whether a cycle exists.
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                    // If both pointers meet, a cycle exists.
                    if (slow == fast) {
                        int length = 0;
                        Node temp = slow;

                        // Counts the nodes inside the cycle.
                        do {
                            temp = temp.next;
                            length++;
                        } while (temp != slow);

                        return length;
                    }
                }
                // Returns 0 if no cycle exists.
                return 0;
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

            // Creates a cycle starting at index 2.
            list.createCycle(2);

            // Calculates the length of the cycle.
            System.out.println("Length of Cycle: " + list.lengthOfCycle());

            LinkedList list2 = new LinkedList();

            // Creates a Linked List without a cycle.
            list2.insertLast(1);
            list2.insertLast(2);
            list2.insertLast(3);
            list2.insertLast(4);

            System.out.println("Length of Cycle: " + list2.lengthOfCycle());
        }
    }
