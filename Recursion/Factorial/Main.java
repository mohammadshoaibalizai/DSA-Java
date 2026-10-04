//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
     * Factorial using Recursion
     *
     * Definition:
     * The factorial of a positive integer n is the product
     * of all positive integers from 1 to n.
     *
     * Formula:
     * n! = n × (n - 1)!
     *
     * Example:
     * 5! = 5 × 4 × 3 × 2 × 1 = 120
     *
     * Important:
     * 0! = 1
     *
     * Base Case:
     * When n == 0, return 1.
     *
     * Recursive Case:
     * Return n * factorial(n - 1).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Space Complexity is O(n) because each recursive call
     * is stored in the Call Stack.
     */
    public static void main(String[] args) {
                int number = 5;

                System.out.println("Factorial of " + number + ": "
                        + factorial(number));
            }


            /*
             * Calculates the factorial of a number using recursion.
             *
             * Example:
             * factorial(5)
             *
             * = 5 * factorial(4)
             * = 5 * 4 * factorial(3)
             * = 5 * 4 * 3 * factorial(2)
             * = 5 * 4 * 3 * 2 * factorial(1)
             * = 5 * 4 * 3 * 2 * 1 * factorial(0)
             *
             * factorial(0) returns 1.
             *
             * Final result:
             * 5 * 4 * 3 * 2 * 1 = 120
             */
            static int factorial(int n) {

                // Base Case
                if (n == 0) {
                    return 1;
                }

                // Recursive Case
                return n * factorial(n - 1);
            }
        }
