/*
 * Singly Linked List Implementation in Java
 * Features:
 * 1. Insert at the beginning, end, or a specific index.
 * 2. Insert a node after a specific index.
 * 3. Delete the first node, last node, or a node at a specific index.
 * 4. Delete the node after a specific index.
 * 5. Get a node reference by index.
 * 6. Search for a node by value.
 * 7. Display the list and check its size or empty state.
 * Note:
 * Indexing starts at 0.
 * Java references provide access to objects, but do not expose
 * their actual physical memory addresses.
 * Author: Muhammad Shoaib
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Insert nodes at the end.
        list.insertLast(10);
        list.insertLast(20);
        list.insertLast(30);
        list.insertLast(40);
        System.out.println("Initial Linked List:");
        list.display();
        // Insert 25 after the node at index 1 (value 20).
        list.insertAfter(1, 25);
        System.out.println("\nAfter inserting 25 after index 1:");
        list.display();
        // Insert 15 at index 1.
        list.insert(15, 1);
        System.out.println("\nAfter inserting 15 at index 1:");
        list.display();
        // Search for a node by value.
        Node found = list.find(30);
        System.out.println("\nSearching for value 30:");
        if (found != null) {
            System.out.println("Node found: " + found.value);
        } else {
            System.out.println("Value not found.");
        }
        // Get the node reference at index 2.
        Node node = list.get(2);
        System.out.println("\nValue at index 2: " + node.value);
        // Delete the node immediately after index 1.
        int removedAfter = list.deleteAfter(1);
        System.out.println("\nDeleted after index 1: " + removedAfter);
        list.display();

        // Delete the node at index 0.
        int removedAt = list.deleteAt(0);
        System.out.println("\nDeleted at index 0: " + removedAt);
        list.display();

        // Delete the last node.
        int removedLast = list.deleteLast();
        System.out.println("\nDeleted last node: " + removedLast);
        list.display();

        System.out.println("\nCurrent size: " + list.size());
        System.out.println("Is list empty? " + list.isEmpty());
    }

    private static class Node {
        /*
         * Represents a single node in the linked list.
         */
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    /*
     * Manages all operations on the singly linked list.
     */
    private static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        /*
         * Inserts a new node at the beginning.
         */
        public void insertFirst(int value) {
            Node node = new Node(value);
            node.next = head;
            head = node;
            if (tail == null) {
                tail = node;
            }
            size++;
        }

        /*
         * Inserts a new node at the end.
         */
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

        /*
         * Inserts a new node at the specified index.
         * Valid indexes range from 0 to size.
         */
        public void insert(int value, int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
            }
            if (index == 0) {
                insertFirst(value);
                return;
            }

            if (index == size) {
                insertLast(value);
                return;
            }
            Node previous = get(index - 1);
            Node node = new Node(value);
            node.next = previous.next;
            previous.next = node;
            size++;
        }

        /*
         * Inserts a new node after the node at the specified index.
         */
        public void insertAfter(int index, int value) {
            Node current = get(index);
            Node node = new Node(value);
            node.next = current.next;
            current.next = node;
            if (current == tail) {
                tail = node;
            }
            size++;
        }

        /*
         * Deletes and returns the value of the first node.
         */
        public int deleteFirst() {
            ensureNotEmpty();
            int removedValue = head.value;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return removedValue;
        }

        /*
         * Deletes and returns the value of the last node.
         */
        public int deleteLast() {
            ensureNotEmpty();
            if (size == 1) {
                return deleteFirst();
            }
            Node secondLast = get(size - 2);
            int removedValue = tail.value;
            secondLast.next = null;
            tail = secondLast;
            size--;
            return removedValue;
        }

        /*
         * Deletes and returns the value at the specified index.
         */
        public int deleteAt(int index) {
            checkExistingIndex(index);
            if (index == 0) {
                return deleteFirst();
            }
            if (index == size - 1) {
                return deleteLast();
            }
            Node previous = get(index - 1);
            int removedValue = previous.next.value;
            previous.next = previous.next.next;
            size--;
            return removedValue;
        }

        /*
         * Deletes and returns the value immediately after the given index.
         * Throws an exception if the specified node has no next node.
         */
        public int deleteAfter(int index) {
            Node current = get(index);
            if (current.next == null) {
                throw new IndexOutOfBoundsException(
                        "There is no node after index " + index
                );
            }
            Node nodeToDelete = current.next;
            int removedValue = nodeToDelete.value;
            current.next = nodeToDelete.next;
            if (nodeToDelete == tail) {
                tail = current;
            }
            size--;
            return removedValue;
        }
        /*
         * Returns the node reference at the specified index.
         */
        public Node get(int index) {
            checkExistingIndex(index);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
        /*
         * Searches for the first node containing the specified value.
         * Returns null if the value does not exist.
         */
        public Node find(int value) {
            Node current = head;

            while (current != null) {
                if (current.value == value) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }
        /*
         * Displays all nodes from head to null.
         */
        public void display() {
            Node current = head;
            System.out.print("head -> ");
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
        /*
         * Returns the number of nodes in the list.
         */
        public int size() {
            return size;
        }

        /*
         * Returns true if the list contains no nodes.
         */
        public boolean isEmpty() {
            return head == null;
        }

        /*
         * Throws an exception if the list is empty.
         */
        private void ensureNotEmpty() {
            if (head == null) {
                throw new IllegalStateException(
                        "Cannot delete from an empty linked list."
                );
            }
        }
        /*
         * Validates an index that must refer to an existing node.
         */
        private void checkExistingIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(
                        "Index: " + index + ", size: " + size
                );
            }
        }
    }
}

