public class SortingI{

    // Selection Sort: O(n^2) time complexity in all cases, O(1) space complexity
    public static void selectionSort(int[] arr){
        for(int i = 0;i < arr.length - 1;i++){ //n-1 passes

            int min = i; //assume first index of unsorted part is min

            for(int j = i+1;j < arr.length ;j++){ //traverse the unsorted part hence j = i+1
                if(arr[j] < arr[min]){ //compare with min
                    min = j; //update min index
                }
            }
            
            int temp = arr[i]; //swap arr[i] and arr[min]
            arr[i] = arr[min]; 
            arr[min] = temp;   
        }
    }

    // Bubble Sort : O(n^2) time complexity in worst case and average case, O(1) space complexity
    // O(n) time complexity in best case when array is already sorted that why we use a swapped flag
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            boolean isSorted = true;
            for(int j = 1;j< arr.length - i;j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;  
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

    }

    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    //Insertion Sort: O(n^2) time complexity in worst and average case, O(1) space complexity
    //O(n) time complexity in best case when array is already sorted because we only do n comparisons and no swaps 
    public static void insertionSort(int[] arr){


        for(int i = 0;i < arr.length;i++){
            int j = i;
            
            while(j > 0 && arr[j-1]>arr[j]){
                swap(arr,j-1,j);
                j--;
            }

        }

        /*
        for(int i = 1;i < arr.length;i++){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        */
    }

    public static void main(String[] args) {
        
        //Selection Sort:

        int[] arr = new int[]{5,4,6,2,7};

        for(int idx = 0;idx < arr.length;idx++){
            System.out.print(arr[idx] + " ");
        }

        //selectionSort(arr);

        //bubbleSort(arr);

        insertionSort(arr);

        System.out.println("");
        for(int idx =0;idx < arr.length;idx++){
            
            System.out.print(arr[idx] + " ");
        }
        System.out.println("");
    }
}