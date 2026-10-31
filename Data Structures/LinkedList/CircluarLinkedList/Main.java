
/*
 * Demonstrates Circular Linked List operations.
 *
 * Author: Muhammad Shoaib
 */

        public class Main {

            public static void main(String[] args) {
                CirlLinkedList  list = new  CirlLinkedList ();

                // Insert elements.
                list.insertLast(10);
                list.insertLast(20);
                list.insertLast(30);
                list.insertLast(40);

                System.out.println("Initial Circular Linked List:");
                list.display();

                // Insert at the beginning.
                list.insertFirst(5);
                System.out.println("\nAfter insertFirst(5):");
                list.display();

                // Insert at a specific index.
                list.insert(15, 2);
                System.out.println("\nAfter insert(15, 2):");
                list.display();

                // Insert after index 2.
                list.insertAfter(2, 25);
                System.out.println("\nAfter insertAfter(2, 25):");
                list.display();

                // Search for a value.
                Node found = list.find(30);

                System.out.println("\nSearching for 30:");

                if (found != null) {
                    System.out.println("Node found: " + found.value);
                } else {
                    System.out.println("Value not found.");
                }

                // Get a node by index.
                System.out.println("\nValue at index 2: " + list.get(2).value);

                // Delete after a specific index.
                System.out.println("\nDeleted after index 2: "
                        + list.deleteAfter(2));
                list.display();

                // Delete at a specific index.
                System.out.println("\nDeleted at index 1: "
                        + list.deleteAt(1));
                list.display();

                // Delete first and last nodes.
                System.out.println("\nDeleted first: " + list.deleteFirst());
                System.out.println("Deleted last: " + list.deleteLast());

                list.display();

                // Display list information.
                System.out.println("\nSize: " + list.size());
                System.out.println("Is Empty: " + list.isEmpty());
            }
        }
