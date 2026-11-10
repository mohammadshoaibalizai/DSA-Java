//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {        /*
 * Array Problems
 *
 * This file contains important array-based problems
 * for practicing Data Structures and Algorithms.
 *
 * Time Complexity:
 * Most problems: O(n)
 *
 * Space Complexity:
 * Most problems: O(1)
 */

    public static void main(String[] args) {

                // 1. Reverse Array
                int[] numbers = {10,20,30,40,50,};
                System.out.println("Original Array reversing");
                for(int number:numbers){
                    System.out.print(" "+number);
                }

                reverseArray(numbers);

                System.out.println("\n after Reversed Array:");
                for (int number : numbers) {
                    System.out.print(number + " ");
                }

             System.out.println("\n---------------------------------------------------------");
                // 2. Second Largest Element
                int [] arr2={2,3,4,10,9};
                System.out.println("\n\nOriginal array for finding the second largest element ");
                for(int number2:arr2){
                    System.out.print(" "+number2);
                }
                System.out.println("\nSecond Largest Element: "
                        + findSecondLargest(arr2));

                // 3. Check if Array is Sorted
        System.out.println("\n---------------------------------------------------------");
        int [] arr3={1,2,3,4,5,7,8};
        System.out.println("\n Original array for for checking whether the array is sorted or not");
        for(int number3:arr3){
            System.out.print(" "+number3);
        }
                System.out.println("\nIs Array Sorted? "
                        + isSorted(arr3));

                // 4. Find Missing Number
        System.out.println("\n---------------------------------------------------------");
              int [] arr4={1,2,3,4,6};
        System.out.println("\nOriginal array for finding the miss number at 1-n  number ");
        for(int number4:arr4){
            System.out.print(" "+number4);
        }
                System.out.println("\nMissing Number: "
                        + findMissingNumber(arr4));


                // 5. Find Duplicate Element
        System.out.println("\n---------------------------------------------------------");
              int [] arr5={1,2,3,4,4,5,6};
        System.out.println("\nOriginal array for finding the duplicate elements ");
        for(int number5:arr5){
            System.out.print(" "+number5);
        }
                 System.out.println("\nDuplicate Element: "
                        + findDuplicate(arr5));

                // 6. Move Zeros to End
        System.out.println("\n---------------------------------------------------------");
              int [] arr6={1,2,0,3,0,4};
        System.out.println("\nOriginal array for moving zero element to the end ");
        for(int number6:arr6){
            System.out.print(" "+number6);
        }
                moveZerosToEnd(arr6);

                System.out.println("\nArray after moving zeros:");

                for (int number : arr6) {
                    System.out.print(number + " ");
                }

                // 7. Count Occurrences
        System.out.println("\n---------------------------------------------------------");
                int[] arr7 = {1, 2, 3, 3, 4, 3};
        System.out.println("\n\n Original array for finding count occurrences ");
        for(int number7:arr7){
            System.out.print(" "+number7);
        }
                System.out.println("\nOccurrences of 3: "
                        + countOccurrences(arr7, 3));
            }


            /*
             * 1. Reverse an Array
             *
             * Reverses the array using two pointers.
             *
             * Example:
             * {10, 20, 30, 40, 50}
             * becomes
             * {50, 40, 30, 20, 10}
             *
             * Time Complexity: O(n)
             * Space Complexity: O(1)
             */
            static void reverseArray(int[] arr) {

                int start = 0;
                int end = arr.length - 1;

                while (start < end) {

                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;

                    start++;
                    end--;
                }
            }


            /*
             * 2. Find Second Largest Element
             *
             * Finds the second largest distinct element.
             *
             * Example:
             * {10, 30, 20, 50, 40}
             * Second largest = 40
             *
             * Time Complexity: O(n)
             * Space Complexity: O(1)
             */
            static int findSecondLargest(int[] arr) {

                int largest = Integer.MIN_VALUE;
                int secondLargest = Integer.MIN_VALUE;

                for (int number : arr) {

                    if (number > largest) {

                        secondLargest = largest;
                        largest = number;

                    } else if (number > secondLargest && number != largest) {

                        secondLargest = number;
                    }
                }

                return secondLargest;
            }


            /*
             * 3. Check if Array is Sorted
             *
             * Checks whether the array is sorted
             * in ascending order.
             *
             * Example:
             * {10, 20, 30, 40} -> true
             * {10, 30, 20, 40} -> false
             *
             * Time Complexity: O(n)
             * Space Complexity: O(1)
             */
            static boolean isSorted(int[] arr) {

                for (int i = 1; i < arr.length; i++) {

                    if (arr[i] < arr[i - 1]) {
                        return false;
                    }
                }

                return true;
            }


            /*
             * 4. Find Missing Number
             *
             * Finds the missing number from 1 to n.
             *
             * Example:
             * {1, 2, 3, 5, 6}
             * Missing number = 4
             *
             * Time Complexity: O(n)
             * Space Complexity: O(1)
             */
            static int findMissingNumber(int[] arr) {

                int n = arr.length + 1;

                int expectedSum = n * (n + 1) / 2;

                int actualSum = 0;

                for (int number : arr) {
                    actualSum += number;
                }

                return expectedSum - actualSum;
            }


            /*
             * 5. Find Duplicate Element
             *
             * Finds a duplicate element in the array.
             *
             * Time Complexity: O(n²)
             * Space Complexity: O(1)
             */
            static int findDuplicate(int[] arr) {

                for (int i = 0; i < arr.length; i++) {

                    for (int j = i + 1; j < arr.length; j++) {

                        if (arr[i] == arr[j]) {
                            return arr[i];
                        }
                    }
                }

                return -1;
            }


            /*
             * 6. Move Zeros to End
             *
             * Moves all zeros to the end while
             * maintaining the order of other elements.
             *
             * Example:
             * {0, 1, 0, 3, 12}
             * becomes
             * {1, 3, 12, 0, 0}
             *
             * Time Complexity: O(n)
             * Space Complexity: O(1)
             */
            static void moveZerosToEnd(int[] arr) {

                int index = 0;

                for (int number : arr) {

                    if (number != 0) {
                        arr[index] = number;
                        index++;
                    }
                }

                while (index < arr.length) {
                    arr[index] = 0;
                    index++;
                }
            }


            /*
             * 7. Count Occurrences
             *
             * Counts how many times a specific value
             * appears in the array.
             *
             * Time Complexity: O(n)
             * Space Complexity: O(1)
             */
            static int countOccurrences(int[] arr, int target) {

                int count = 0;

                for (int number : arr) {

                    if (number == target) {
                        count++;
                    }
                }

                return count;
            }
        }
