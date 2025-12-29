public class SortingII{

    // Merge Sort Algorithm - Divide and Conquer:
    // Time Complexity: O(n log n) in all cases (worst, average, best)
    // Space Complexity: O(n) due to the temporary array used for merging
    
    public static void mergeSort(int[] arr,int low,int high){  
        
        if(low >= high) return;
            int mid = low + (high - low)/2; // written as low + (high - low)/2 to avoid overflow

            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        
    }

    public static void merge(int[] arr,int low,int mid, int high ){
        int[] temp = new int[high - low + 1]; //Why high - low + 1 ? because we are merging two subarrays from low to high inclusive

        int left = low; // pointer for left subarray
        int right = mid+1; // pointer for right subarray
        int i = 0;

        while(left <= mid && right <= high){ // comparing and merging two subarrays
            if(arr[left] <= arr[right]){ // can be written as < to make it stable
                temp[i] = arr[left];
                i++;
                left++;
            } else{            
                temp[i] = arr[right];
                i++;
                right++;
            }
        }

        while(left <= mid){ // copying remaining elements from left subarray if any
            temp[i] = arr[left]; // can be wriiten as temp[i++] = arr[left++];
            i++;
            left++;
        }

        while(right <= high){ // copying remaining elements from right subarray if any
            temp[i] = arr[right]; // can be wriiten as temp[i++] = arr[right++];
            i++;
            right++;
        }

        for (int k = 0; k < temp.length; k++) { // copying back the sorted elements to original array
            arr[low + k] = temp[k]; 
        }
    }



    // Recursive Bubble Sort:
    public static void recursiveBubbleSort(int[] arr,int size){
        if(size == 1) return; // base case

        for(int i = 0;i < size - 1;i++){ // one pass of bubble sort
            if(arr[i] > arr[i + 1]){
                swap(arr,i,i+1); // swap if elements are out of order
            }
        }

        recursiveBubbleSort(arr,size - 1); // recursive call for the remaining array
                                           // size - 1 because last element is already sorted 
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    // public static void recursiveInsertionSort(int[] arr){

    // }

    public static void quickSort(int[] arr,int low, int high){

        if (low >= high) return;; // base case

        if(low < high){

            int partitionIndex = partition(arr,low,high);

            quickSort(arr,low,partitionIndex-1);

            quickSort(arr,partitionIndex+1,high);

        } 

        
    }

    public static int partition(int[] arr,int low,int high){
        int pivot = arr[low]; // first element as pivot
        int i = low;
        int j = high;
        
        while(i < j){
            while(pivot >= arr[i] && i < high){
                i++;
            }

            while(pivot < arr[j] && j > low){
                j--;
            }

            if(i < j){
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);
        return j;
    }


    public static void main(String[] args) {
        
        int[] arr = new int[]{4,3,5,2,1}; 

        for (int i = 0; i < arr.length; i++) { 
            System.out.print(arr[i] + " ");
        }

        //mergeSort(arr,0,arr.length-1);

        quickSort(arr,0,arr.length-1);

        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}