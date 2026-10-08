//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
     * Fibonacci Number using Recursion
     *
     * Definition:
     * The Fibonacci sequence is a sequence in which
     * each number is the sum of the two previous numbers.
     *
     * Sequence:
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
     *
     * Formula:
     * fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2)
     *
     * Base Cases:
     * fibonacci(0) = 0
     * fibonacci(1) = 1
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     *
     * Space Complexity is O(n) because recursive calls
     * are stored in the Call Stack.
     */

        public static void main(String[] args) {

            int number = 7;

            System.out.println("Fibonacci number at position "
                    + number + ": " + fibonacci(number));
        }

        /*
         * Calculates the Fibonacci number using recursion.
         *
         * Example:
         * fibonacci(5)
         *
         * = fibonacci(4) + fibonacci(3)
         * = (fibonacci(3) + fibonacci(2))
         *   + (fibonacci(2) + fibonacci(1))
         *
         * Base cases stop the recursion:
         * fibonacci(0) = 0
         * fibonacci(1) = 1
         */
        static int fibonacci(int n) {

            // Base Case
            if (n == 0) {
                return 0;
            }

            if (n == 1) {
                return 1;
            }

            // Recursive Case
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }