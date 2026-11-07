import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
int []arr={7,5,4,1,2,3,6};
int [] ans= mergeSort(arr);
System.out.println(Arrays.toString(ans));
    }
// Merge Sort Algorithm
//
// Divide the array into two halves recursively until each subarray
// contains only one element.
//
// Then merge the subarrays by comparing their elements and placing
// them in sorted order.
//
// Time Complexity:
// Best Case: O(n log n)
// Average Case: O(n log n)
// Worst Case: O(n log n)
//
// Space Complexity: O(n)
//
// Not an in-place sorting algorithm because it uses additional
// arrays during the merging process.

    static int[] mergeSort(int [] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = (arr.length / 2);
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
 return merge(left,right);

    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if(first[i] > second[j]) {
                mix[k] = second[j];
                j++;
            } else {
                mix[k] = first[i];
                i++;
            }
            k++;
        }
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
        
        }
        }