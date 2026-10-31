/*
 * Circular Singly Linked List Implementation in Java.
 *
 * In a circular linked list, the last node points back to the head.
 *
 * Features:
 * 1. Insert at the beginning, end, or a specific index.
 * 2. Insert after a specific index.
 * 3. Delete the first node, last node, or a specific index.
 * 4. Delete the node after a specific index.
 * 5. Get a node by index.
 * 6. Search for a node by value.
 * 7. Display all nodes.
 *
 * Author: Muhammad Shoaib
 */
    public class CirlLinkedList {

        private Node head;
        private Node tail;
        private int size;

        /**
         * Inserts a node at the beginning.
         */
        public void insertFirst(int value) {
            Node node = new Node(value);

            if (head == null) {
                head = node;
                tail = node;
                node.next = head;
            } else {
                node.next = head;
                head = node;
                tail.next = head;
            }

            size++;
        }

        /**
         * Inserts a node at the end.
         */
        public void insertLast(int value) {
            Node node = new Node(value);

            if (head == null) {
                head = node;
                tail = node;
                node.next = head;
            } else {
                tail.next = node;
                tail = node;
                tail.next = head;
            }

            size++;
        }

        /**
         * Inserts a node at a specific index.
         */
        public void insert(int value, int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Invalid index.");
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

        /**
         * Inserts a node after the specified index.
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

        /**
         * Deletes the first node.
         */
        public int deleteFirst() {
            ensureNotEmpty();

            int removedValue = head.value;

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            size--;
            return removedValue;
        }

        /**
         * Deletes the last node.
         */
        public int deleteLast() {
            ensureNotEmpty();

            if (size == 1) {
                return deleteFirst();
            }

            Node secondLast = get(size - 2);
            int removedValue = tail.value;

            tail = secondLast;
            tail.next = head;

            size--;
            return removedValue;
        }

        /**
         * Deletes a node at a specific index.
         */
        public int deleteAt(int index) {
            checkIndex(index);

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

        /**
         * Deletes the node after the specified index.
         */
        public int deleteAfter(int index) {
            Node current = get(index);

            if (size == 1) {
                throw new IllegalStateException(
                        "There is no node after the only node."
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

        /**
         * Returns the node at a specific index.
         */
        public Node get(int index) {
            checkIndex(index);

            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current;
        }

        /**
         * Searches for a node by value.
         */
        public Node find(int value) {
            if (head == null) {
                return null;
            }

            Node current = head;

            do {
                if (current.value == value) {
                    return current;
                }

                current = current.next;

            } while (current != head);

            return null;
        }

        /**
         * Displays the circular linked list.
         */
        public void display() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }

            Node current = head;

            System.out.print("head -> ");

            do {
                System.out.print(current.value + " -> ");
                current = current.next;

            } while (current != head);

            System.out.println("(back to head)");
        }

        /**
         * Returns the number of nodes.
         */
        public int size() {
            return size;
        }

        /**
         * Checks whether the list is empty.
         */
        public boolean isEmpty() {
            return head == null;
        }

        /**
         * Validates an index that must refer to an existing node.
         */
        private void checkIndex(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(
                        "Index: " + index + ", Size: " + size
                );
            }
        }

        /**
         * Checks whether the list is empty before deletion.
         */
        private void ensureNotEmpty() {
            if (isEmpty()) {
                throw new IllegalStateException(
                        "Cannot delete from an empty list."
                );
            }
        }
    }

