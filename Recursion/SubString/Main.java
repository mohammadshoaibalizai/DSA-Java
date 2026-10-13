//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
/*
 * Problem: Generate all subsets of a string using recursion.
 * Topic: Recursion
 *
 * Example input: "abc"
 *
 * For every character, we make two choices:
 * 1. Exclude the character.
 * 2. Include the character.
 *
 * p  = Selected characters so far.
 * up = Characters remaining to process.
 */

            public static void main(String[] args) {

                String input = "abc";

                // Start with an empty subset and all characters unprocessed.
                subset("", input);
            }

            /*
             * Generates all possible subsets of a string.
             *
             * @param p  Current subset built so far.
             * @param up Remaining characters to process.
             */
            static void subset(String p, String up) {

                // BASE CASE:
                // If no characters remain, print the completed subset.
                if (up.isEmpty()) {
                    System.out.println(p);
                    return;
                }

                // Get the first character of the remaining string.
                char ch = up.charAt(0);
                // Remove the first character.
                String remaining = up.substring(1);

                // CHOICE 1: Exclude the current character.
                subset(p, remaining);

                // CHOICE 2: Include the current character.
                subset(p + ch, remaining);
            }
        }
