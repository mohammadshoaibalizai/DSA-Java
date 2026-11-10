/*
 * Two Sum Problem in a Sorted Array
 *
 * This program finds two elements in a sorted array
 * whose sum is equal to the given target value.
 *
 * Algorithm: Two Pointer Technique
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Muhammad Shoaib
 */

public class TwoSumSortedArray {

    /*
     * Finds two indices whose elements add up to the target.
     *
     * @param arr    A sorted array of integers
     * @param target The required sum of two elements
     * @return The indices of the two elements if found;
     *         otherwise, returns {-1, -1}
     */
    public static int[] twoSum(int[] arr, int target) {

        // Start the left pointer at the first array element
        int left = 0;

        // Start the right pointer at the last array element
        int right = arr.length - 1;

        // Search for the required pair while the pointers do not meet
        while (left < right) {

            // Calculate the sum of the elements at both pointers
            int sum = arr[left] + arr[right];

            // Check whether the current pair matches the target
            if (sum == target) {

                // Return the indices of the two matching elements
                return new int[]{left, right};

            } else if (sum < target) {

                // The sum is too small, so move the left pointer
                // to a larger element in the sorted array
                left++;

            } else {

                // The sum is too large, so move the right pointer
                // to a smaller element in the sorted array
                right--;
            }
        }

        // Return -1 for both indices if no valid pair is found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        // Initialize a sorted array in ascending order
        int[] arr = {1, 2, 4, 6, 8, 9};

        // Define the target sum that the two elements must equal
        int target = 10;

        // Call the twoSum method to find the required pair
        int[] result = twoSum(arr, target);

        // Check whether a valid pair of indices was returned
        if (result[0] != -1) {

            // Display the indices of the two matching elements
            System.out.println("Indices: " + result[0] + ", " + result[1]);

            // Display the actual values at the returned indices
            System.out.println(
                    "Values: " + arr[result[0]] + ", " + arr[result[1]]
            );

        } else {

            // Display a message when no pair matches the target
            System.out.println("No valid pair found.");
        }
    }
}