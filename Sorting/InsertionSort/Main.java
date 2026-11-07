import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        int [] arr={7,6,5,4,3,2,1,9,0};
        insertionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // Insertion Sort Algorithm
   // Build the sorted part of the array one element at a time.
   // Compare the current element with previous elements
  // and move it to its correct position.
  //
  // Time Complexity:
  // Best Case: O(n)
  // Average Case: O(n²)
 // Worst Case: O(n²)
 // Space Complexity: O(1)
 // In-place sorting algorithm.
static void insertionsort(int [] arr){
    for(int i=0;i<arr.length-1;i++){
        for(int j=i+1;j>0;j--){  
            if(arr[j]<arr[j-1]){
                swap(arr,j,j-1);
            }else {
                break;
            }
           }
       }
     }
static void swap(int []arr,int first,int second){
  int temp=arr[first];
  arr[first]=arr[second];
  arr[second]=temp;}
}