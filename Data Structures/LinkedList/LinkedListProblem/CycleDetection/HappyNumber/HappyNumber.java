
/*
 * Happy Number - Floyd's Cycle Detection Algorithm
 *
 * Description:
 * Determines whether a number is a Happy Number using
 * the slow and fast pointer technique.
 *
 * A Happy Number eventually reaches 1 when repeatedly
 * replaced by the sum of the squares of its digits.
 *
 * If the sequence enters a cycle that does not include 1,
 * the number is not a Happy Number.
 *
 * Note:
 * This solution uses an implicit sequence similar to a
 * Linked List. It does not create actual Node objects.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * Author: Muhammad Shoaib
 */

public class HappyNumber {

    // Returns the sum of the squares of the digits of n.
    public static int nextNumber(int n) {

        int sum = 0;

        while (n > 0) {

            int digit = n % 10;

            sum += digit * digit;

            n = n / 10;
        }

        return sum;
    }

    // Detects a cycle using Floyd's Cycle Detection Algorithm.
    public static boolean isHappy(int n) {

        if (n <= 0) {
            return false;
        }

        int slow = n;
        int fast = n;

        do {

            // Slow moves one step.
            slow = nextNumber(slow);

            // Fast moves two steps.
            fast = nextNumber(nextNumber(fast));

        } while (slow != fast);

        // Returns true if the meeting point is 1.
        return slow == 1;
    }

    public static void main(String[] args) {

        int number = 19;

        if (isHappy(number)) {
            System.out.println(number + " is a Happy Number.");
        } else {
            System.out.println(number + " is not a Happy Number.");
        }
    }
}
