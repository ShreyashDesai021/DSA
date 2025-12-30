import java.util.*;

public class ArraysEasy {

    public static int secLargest(int[] arr){

        // if(arr.length < 2){
        //     return -1;
        // }

        // int max = Integer.MIN_VALUE;

        // for(int i : arr){
        //    if(i > max){
        //         max = i;
        //    } 
        // }

        // int secMax = Integer.MIN_VALUE;

        // for(int i : arr){
        //     if(i != max && i > secMax){
        //         secMax = i;
        //     }
        // }

        // if(secMax == Integer.MIN_VALUE){
        //     return -1;
        // }

        // return secMax;

        //Enhanced Approach:
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        if (arr.length < 2) return -1; 

        int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;

        // Loop through the array to find the second largest element
        for (int i = 0; i < arr.length; i++) {
            // Update the largest and second largest values
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } 
            else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large; // Return the second largest element

    }

    public static boolean checkSorted(int[] arr){
        if(arr.length < 2) return true;

                for(int i = 1 ; i < arr.length;i++){
                            if(arr[i-1] > arr[i]){
                                            return false;
                                                        }
                                                                }
                                                                        return true;
    }

    public static int removeDuplicate(int[] arr){ // Using HashSet 
        HashSet<Integer> hs = new HashSet<>();

        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(!hs.contains(arr[i])){ 
                hs.add(arr[i]);

                arr[index] = arr[i];

                index++;

            }
            
        }

        return index;
    }

    public static int removeDuplicateEnhanced(int[] arr){

        int j = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                arr[j] = arr[i];
                j++;
            }
            
        }
        return j;

    }

    public static void leftRotateBy1(int[] arr){
        if (arr.length <= 1) return;

        int x = arr[0]; // store the first element in a variable

        for(int i = 1;i< arr.length;i++){ // shift elements to left by one position
            arr[i-1] = arr[i]; 
        }

        arr[arr.length-1] = x; // place the first element at the end of the array

    }

    public static void leftRotateByd(int[] arr,int d){ // brute
        if(arr.length <= 1) return;

        if(d >= arr.length){ // if d is more than length of array
            d = d % arr.length;
        }

        ArrayList<Integer> list = new ArrayList<>(); 

        for(int i = 0;i<d;i++){ // store first d elements in arraylist
            list.add(arr[i]);
        }

        for(int i= d;i< arr.length;i++){ // shift elements to left by d positions
            arr[i-d] = arr[i];
        }

        int j = 0;
        for(int i = arr.length-d;i<arr.length;i++){ // place the stored d elements at the end of the array
            arr[i] = list.get(j); // prefered way as getting from arraylist is O(1)
            j++;
            //arr[i] = list.remove(0); // remove from start , it works but not efficient because removing from start takes O(n)
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void leftRotateBydOptimal(int[] arr,int d){
        if(arr.length <= 1) return;

        if(d >= arr.length){ // if d is more than length of array
            d = d % arr.length;
        }


        reverse(arr,0,d-1);

        reverse(arr,d,arr.length-1);

        reverse(arr,0,arr.length-1);
        
    }

    public static void moveZerostoEnd(int[] arr){
        
        int j = 0;
        for(int i = 0;i < arr.length;i++){ // swap will only be called when non-zero element is found 
                                        // so it swaps non-zero and zero elements only // ahead of swapped element j++ will again point to next zero element 
                                        // which will be available just after the last swapped non-zero element // so no need to worry if j is poitning to non-zero element
            if(arr[i] != 0){
                swap(arr,i,j);
                j++;
            }
        }
    }

    public static int[] unionOfArrays(int[] arr1, int[] arr2){

        LinkedHashSet<Integer> lh = new LinkedHashSet<>();

        for(int i = 0;i < arr1.length;i++){
            lh.add(arr1[i]);
        }

        for(int i = 0;i < arr1.length;i++){
            lh.add(arr2[i]);
        }

        for (int x : lh) {
            
        }

        return 

    }

    public static void main(String[] args) {
        
        int[] arr = new int[]{1,0,2,3,2,0,0,4,5,1,0}; 

        for (int i = 0; i < arr.length; i++) { 
            System.out.print(arr[i] + " ");
        }

        System.err.println("");
        // System.out.println(secLargest(arr));
        // System.err.println(checkSorted(arr));
        //System.out.println(removeDuplicateEnhanced(arr));

        // leftRotateBy1(arr);
        //leftRotateByd(arr,6);

        // leftRotateBydOptimal(arr,3);
        moveZerostoEnd(arr);

        for (int i = 0; i < arr.length; i++) { 
            System.out.print(arr[i] + " ");
        }

    }
}