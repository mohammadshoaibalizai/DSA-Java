//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    /*
     * Digit Sum using Recursion
     *
     * Definition:
     * Digit Sum is the process of adding all digits of a number.
     *
     * Example:
     * 12345
     * 1 + 2 + 3 + 4 + 5 = 15
     *
     * Recursive Idea:
     * digitSum(n) = n % 10 + digitSum(n / 10)
     *
     * Base Case:
     * When n == 0, return 0.
     *
     * Time Complexity: O(d)
     * Space Complexity: O(d)
     *
     * d = number of digits
     */
    public static void main(String[] args) {
                int number = 12345;
                System.out.println("Digit Sum of " + number + ": "
                        + digitSum(number));
            }

            /*
             * Calculates the sum of all digits using recursion.
             *
             * Example:
             * digitSum(12345)
             *
             * = 5 + digitSum(1234)
             * = 5 + 4 + digitSum(123)
             * = 5 + 4 + 3 + digitSum(12)
             * = 5 + 4 + 3 + 2 + digitSum(1)
             * = 5 + 4 + 3 + 2 + 1 + digitSum(0)
             *
             * digitSum(0) returns 0.
             *
             * Final result:
             * 1 + 2 + 3 + 4 + 5 = 15
             */
            static int digitSum(int n) {

                // Base Case
                if (n == 0) {
                    return 0;
                }

                // Recursive Case
                return (n % 10) + digitSum(n / 10);
            }
        }
