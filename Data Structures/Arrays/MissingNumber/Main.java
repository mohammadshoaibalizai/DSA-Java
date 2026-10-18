
/*
 * Program: Missing Number in an Array
 *
 * Description:
 * Finds the missing number in an array containing distinct
  numbers from 1 to N, where exactly one number is missing.

 * Example:
 * Input:  {1, 2, 4, 5, 6}
 * Output: Missing number: 3
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 Algorithm :
 1.Find N by adding 1 to the array length
 2. Calculate the expected sum from 1 to N
 3.Calculate the  actual sum of array elements.
 4.Subtract actualSum from expectedSum
 5.Return the result as the missing number.
 */
       public class Main{

            public static int findMissingNumber(int[] arr) {
                int n = arr.length + 1;

                // Sum of numbers from 1 to N
                int expectedSum = n * (n + 1) / 2;

                // Calculate the actual sum of array elements
                int actualSum = 0;

                for (int num : arr) {
                    actualSum += num;
                }

                // Difference gives the missing number
                return expectedSum - actualSum;
            }

            public static void main(String[] args) {
                int[] arr = {1, 2, 4, 5, 6};

                int missing = findMissingNumber(arr);

                System.out.println("Missing number: " + missing);
            }
        }

