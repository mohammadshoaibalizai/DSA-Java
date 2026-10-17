
import java.util.ArrayList;
import java.util.List;
        public class Main {
            public static void main(String[] args) {
                int[] arr = {1, 2, 3};
                System.out.println("All Subsets of the Array:");
                findSubsets(arr, 0, new ArrayList<>());
            }
            /*
             * Generates all possible subsets of an array.
             *
             * @param arr     the input array
             * @param index   the current element index
             * @param current the subset being constructed
         */static void findSubsets(int[] arr, int index, List<Integer> current) {
                 /* Base Case: all elements have been processed */
                if (index == arr.length) {
                    System.out.println(current);
                    return;
                }
                // Choice 1: Include the current element
                current.add(arr[index]);
                findSubsets(arr, index + 1, current);
                // Backtracking: remove the current element
                current.remove(current.size() - 1);
                // Choice 2: Exclude the current element
                findSubsets(arr, index + 1, current);
            }
       
        }