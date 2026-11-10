
/*
 * Problem: Rotate Array
 * LeetCode: 189
 * Difficulty: Medium
 *
 * Problem Description:
 * Given an integer array, rotate the array to the right
 * by k positions.
 *
 * Example:
 * Input:  nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 * Output: [5, 6, 7, 1, 2, 3, 4]
 *
 * Approach: Reversal Algorithm
 *
 * Main Idea:
 * Instead of moving elements one by one, we use
 * three reverse operations to rotate the array.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {

        // Handle an empty or null array.
        if (nums == null || nums.length == 0) {
            return;
        }

        // Step 1: Reduce unnecessary rotations.
        // Rotating an array by its length brings it
        // back to its original position.
        // Therefore, k % nums.length gives the
        // actual number of rotations required.
        k = k % nums.length;


        // Step 2: Reverse the entire array.
        // This moves the last k elements to the beginning,
        // but their relative order becomes reversed.
        reverse(nums, 0, nums.length - 1);


        // Step 3: Reverse the first k elements.
        // This restores the original order of the elements
        // that were moved from the end to the beginning.
        reverse(nums, 0, k - 1);


        // Step 4: Reverse the remaining elements.
        // This restores the original order of the
        // elements that belong after the first k elements.
        // Now the array is rotated to the right by k positions.
        reverse(nums, k, nums.length - 1);
    }


    /*
     * Reverses a specific portion of the array.
     *
     * Algorithm:
     * 1. Use two pointers: start and end.
     * 2. Store the element at the start index in temp.
     * 3. Move the element at end to the start position.
     * 4. Move the stored element to the end position.
     * 5. Move start forward and end backward.
     * 6. Repeat until start is no longer less than end.
     *
     * This method modifies the original array
     * without creating an additional array.
     */
    private static void reverse(int[] nums, int start, int end) {

        // Continue swapping elements until both pointers meet.
        while (start < end) {

            // Temporarily store the left-side element.
            int temp = nums[start];

            // Move the right-side element to the left position.
            nums[start] = nums[end];

            // Move the stored left-side element to the right position.
            nums[end] = temp;

            // Move both pointers toward the center.
            start++;
            end--;
        }
    }


    public static void main(String[] args) {

        // Create the input array.

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
       System.out.println( "Main Array   "+Arrays.toString(nums));
        // Number of positions to rotate to the right.
        int k = 3;

        // Rotate the original array.
        rotate(nums, k);

        System.out.println("k =3");
        // Display the resulting array.
        System.out.println("Rotated Array " +Arrays.toString(nums));
    }
}

