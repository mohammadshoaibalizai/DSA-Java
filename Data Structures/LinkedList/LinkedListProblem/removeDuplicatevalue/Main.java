/*
 * Remove Duplicates from a Sorted Linked List
 *
 * This program demonstrates:
 * 1. Creating nodes in a Linked List.
 * 2. Inserting elements at the beginning.
 * 3. Removing duplicate elements.
 * 4. Displaying the Linked List.
 * 5. Maintaining the size and tail references.
 *
 * Note:
 * This algorithm works correctly when the Linked List is sorted.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
        class LinkedList {

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

            // Inserts a new node at the beginning of the Linked List.
            public void insertFirst(int value) {

                Node node = new Node(value);

                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    node.next = head;
                    head = node;
                }

                size++;
            }

            // Removes consecutive duplicate elements from the Linked List.
            public void removeDuplicates() {

                if (head == null) {
                    return;
                }

                Node temp = head;

                while (temp.next != null) {

                    if (temp.value == temp.next.value) {

                        // Skips the duplicate node.
                        temp.next = temp.next.next;

                        size--;

                    } else {

                        // Moves to the next node.
                        temp = temp.next;
                    }
                }

                // Updates tail after removing duplicate nodes.
                tail = temp;
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
        }

        public class Main {

            public static void main(String[] args) {

                LinkedList list = new LinkedList();

                // Inserting elements into the Linked List.
                list.insertFirst(10);
                list.insertFirst(10);
                list.insertFirst(30);
                list.insertFirst(35);
                list.insertFirst(35);
                System.out.println("Original Linked List:");
                list.display();

                // Removes duplicate elements.
                list.removeDuplicates();

                System.out.println("\nLinked List After Removing Duplicates:");
                list.display();

                System.out.println("Size: " + list.getSize());
            }
        }
