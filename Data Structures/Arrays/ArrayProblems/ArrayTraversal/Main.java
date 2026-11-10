//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
     * Array Traversal
     *
     * Definition:
     * Array traversal is the process of visiting and processing
     * each element of an array, usually from the first element
     * to the last element.
     *
     * Traversal is commonly used to:
     * - Display array elements
     * - Calculate the sum of elements
     * - Find the maximum or minimum element
     * - Search for a specific value
     * - Perform operations on every element
     *
     * Common Traversal Methods:
     * 1. Traditional for loop
     * 2. Enhanced for loop (for-each)
     * 3. while loop
     * 4. Reverse traversal
     *
     * Time Complexity:
     * - Traversing an array: O(n)
     *
     * Space Complexity:
     * - O(1) when no additional data structure is used.
     */

    public static void main(String[] args) {

                // Example array
                int[] numbers = {10, 20, 30, 40, 50};

                /*
                 * ------------------------------------------------
                 * 1. Traversal using a traditional for loop
                 * ------------------------------------------------
                 *
                 * The index starts from 0 and continues until
                 * index < numbers.length.
                 */
                System.out.println("Traversal using for loop:");

                for (int i = 0; i < numbers.length; i++) {
                    System.out.print(numbers[i] + " ");
                }

                /*
                 * ------------------------------------------------
                 * 2. Traversal using an enhanced for loop
                 * ------------------------------------------------
                 *
                 * The for-each loop directly gives us each element
                 * without manually working with indexes.
                 */
                System.out.println("\n\nTraversal using for-each loop:");

                for (int number : numbers) {
                    System.out.print(number + " ");
                }

                /*
                 * ------------------------------------------------
                 * 3. Traversal using a while loop
                 * ------------------------------------------------
                 */
                System.out.println("\n\nTraversal using while loop:");

                int i = 0;

                while (i < numbers.length) {
                    System.out.print(numbers[i] + " ");
                    i++;
                }

                /*
                 * ------------------------------------------------
                 * 4. Reverse traversal
                 * ------------------------------------------------
                 *
                 * We start from the last index and move toward index 0.
                 */
                System.out.println("\n\nReverse traversal:");

                for (int j = numbers.length - 1; j >= 0; j--) {
                    System.out.print(numbers[j] + " ");
                }

                /*
                 * ------------------------------------------------
                 * 5. Calculate the sum during traversal
                 * ------------------------------------------------
                 */
                int sum = 0;

                for (int number : numbers) {
                    sum += number;
                }

                System.out.println("\n\nSum of elements: " + sum);

                /*
                 * ------------------------------------------------
                 * 6. Find the largest element during traversal
                 * ------------------------------------------------
                 */
                int largest = numbers[0];

                for (int number : numbers) {

                    if (number > largest) {
                        largest = number;
                    }
                }

                System.out.println("Largest element: " + largest);

                /*
                 * ------------------------------------------------
                 * 7. Find the smallest element during traversal
                 * ------------------------------------------------
                 */
                int smallest = numbers[0];

                for (int number : numbers) {

                    if (number < smallest) {
                        smallest = number;
                    }
                }

                System.out.println("Smallest element: " + smallest);
            }
        }
