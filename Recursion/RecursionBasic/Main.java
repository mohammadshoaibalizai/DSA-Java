//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /*
 * Recursion Basics

 * Definition:
 * Recursion is a programming technique in which a method
  calls itself to solve a problem by breaking it into
  smaller subproblems.

 * Every recursive method should have:
 * 1. Base Case
 * 2. Recursive Case

 * Base Case: The condition that stops the recursion.

 * Recursive Case:
 * The part where the method calls itself with a smaller or simpler input.

 * Important:
 * Without a proper base case, recursion may continue
  indefinitely and cause StackOverflowError.

 * Time Complexity:Depends on the recursive algorithm.
 * Space Complexity: Recursive calls use the Call Stack.
     */
public static void main(String[] args) {
        System.out.println("Countdown from 5 :");
        countdown(5);
        System.out.println("\nNumbers from 1 to 5:");
        printNumbers(1, 5);

        System.out.println("\n\nSum from 1 to 5:");
        System.out.println(sum(5));
    }


    /*
     * Example 1: Countdown
     * Prints numbers from n down to 1.
     * Example:countdown(5)
     * Output:
     * 5 4 3 2 1
     * Base Case:
     * n == 0
     *
     * Recursive Case:
     * countdown(n - 1)

     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
            static void countdown(int n) {
                if (n == 0) {
                    return;
                }

                System.out.print(n + " ");

                countdown(n - 1);
            }

            /*
             * Example 2: Print Numbers from 1 to n
             * Prints numbers in ascending order using recursion.
             *
             * Example: printNumbers(1, 5)
             * Output: 1 2 3 4 5
             * Base Case: start > end
             * Recursive Case:
             * printNumbers(start + 1, end)
             *
             * Time Complexity: O(n)
             * Space Complexity: O(n)
             */
            static void printNumbers(int start, int end) {

                if (start > end) {
                    return;
                }

                System.out.print(start + " ");

                printNumbers(start + 1, end);
            }

            /*
             * Example 3: Sum of Numbers
             * Calculates the sum of numbers from 1 to n.
             *  Base Case: n == 0
             * Recursive Case: n + sum(n - 1)
             * Time complexity: O(n)
             * Space Complexity: O(n)
             * Example: sum(5)
             * sum(5)
             * = 5 + sum(4)
             * = 5 + 4 + sum(3)
             * = 5 + 4 + 3 + sum(2)
             * = 5 + 4 + 3 + 2 + sum(1)
             * = 5 + 4 + 3 + 2 + 1 + sum(0)
             * Final result:
             * 5 + 4 + 3 + 2 + 1 = 15
            
             */
            static int sum(int n) {

                if (n == 0) {
                    return 0;
                }
              return n + sum(n - 1);
            }
        }

