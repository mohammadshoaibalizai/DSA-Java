     /*
      * Problem: Find the Second Largest Element
      * Topic: Arrays
      * Repository: DSA-Java
      *
      * Description:
      * Find the second-largest DISTINCT element in an array
      * without sorting the array.
      *
      * Example:
      * Input:  {10, 5, 20, 8, 15}
      * Output: 15
      *
      * Approach:
      * 1. Maintain two variables: largest and secondLargest.
      * 2. Traverse the array once.
      * 3. Update largest and secondLargest when necessary.
      * 4. If no second distinct largest element exists,
      *    report that no answer is available.
      *
      * Time Complexity: O(n)
      * Space Complexity: O(1)
      */


        public class Main {

            public static void main(String[] args) {

                int[] arr = {10, 5, 20, 8, 15};

                // Find the second-largest distinct element.
                int result = findSecondLargest(arr);

                if (result == Integer.MIN_VALUE) {
                    System.out.println(
                            "Second largest distinct element does not exist."
                    );
                } else {
                    System.out.println("Array elements:");

                    for (int num : arr) {
                        System.out.print(num + " ");
                    }

                    System.out.println();
                    System.out.println("Second Largest: " + result);
                }
            }

            /*
             * Finds the second-largest DISTINCT element.
             * Returns Integer.MIN_VALUE if no answer exists.
             */
            public static int findSecondLargest(int[] arr) {

                if (arr == null || arr.length < 2) {
                    return Integer.MIN_VALUE;
                }

                int largest = Integer.MIN_VALUE;
                int secondLargest = Integer.MIN_VALUE;

                for (int num : arr) {

                    if (num > largest) {

                        // The previous largest becomes second largest.
                        secondLargest = largest;
                        largest = num;

                    } else if (num < largest && num > secondLargest) {

                        // Update second largest if the number is
                        // smaller than largest but greater than
                        // the current second largest.
                        secondLargest = num;
                    }
                }

                return secondLargest;
            }
        }

