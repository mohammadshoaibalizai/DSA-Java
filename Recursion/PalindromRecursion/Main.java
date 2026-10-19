
/*
 * Program: Palindrome Check Using Recursion
 *
 * Description:
 * Checks whether a string is a palindrome using recursion.
 * A palindrome reads the same forward and backward.
 *
 * Example:
 * Input:  "level"
 * Output: The string is a palindrome.
 *
 * Algorithm:
 * 1. Start with the first and last indexes.
 * 2. If left >= right, return true.
 * 3. If the characters are different, return false.
 * 4. Otherwise, recursively check the inner characters.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Main {

    public static boolean isPalindrome(String str, int left, int right) {
                // Base case
                if (left >= right) {
                    return true;
                }
                // If characters do not match
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }

                // Recursive case
                return isPalindrome(str, left + 1, right - 1);
            }

            public static void main(String[] args) {

                String str = "level";

                boolean result = isPalindrome(
                        str, 0, str.length() - 1);

                if (result) {
                    System.out.println("The string is a palindrome.");
                } else {
                    System.out.println("The string is not a palindrome.");
                }
            }
        }

