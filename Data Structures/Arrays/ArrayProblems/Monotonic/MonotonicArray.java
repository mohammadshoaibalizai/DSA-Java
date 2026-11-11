import java.util.Arrays;

public class MonotonicArray {

    public static void main(String[] args) {

        // Example array to check whether it is monotonic
        int[] arr = {1, 1, 8, 2, 3};
        //Example for monotonic array
        int [] arr2={1,2,3,4,5,6,7};

        // Call the monotonic method and store the result
        boolean result = monotonic(arr);
        boolean result2=monotonic(arr2);
        // Print the final result
        System.out.println(Arrays.toString(arr));
        System.out.println("Is Monotonic: " + result);
        System.out.println(Arrays.toString(arr2));
        System.out.println("Is Monotonic: " + result2);
    }

    /*
     * Checks whether the given array is monotonic.
     *
     * An array is monotonic if it is either:
     * 1. Monotonic Increasing: Every next element is greater
     *    than or equal to the previous element.
     *
     * 2. Monotonic Decreasing: Every next element is smaller
     *    than or equal to the previous element.
     *
     * Approach:
     * - Use two counters to track increasing and decreasing pairs.
     * - Compare each element with its next element.
     * - If the current element is less than or equal to the next,
     *   increment the increasing counter.
     * - Otherwise, increment the decreasing counter.
     * - If all pairs follow either direction, return true.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean monotonic(int[] arr) {

        // Count the number of increasing and decreasing pairs
        int increasing = 0;
        int decreasing = 0;

        // Compare each element with the next element
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] <= arr[i + 1]) {
                increasing++;
            } else {
                decreasing++;
            }
        }

        // If all pairs follow one direction, the array is monotonic
        return increasing == arr.length - 1 ||
                decreasing == arr.length - 1;
    }
}
