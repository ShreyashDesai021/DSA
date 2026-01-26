
public class BinarySearch{
    // BS Iterative // Time Complexity: O(log n) , Space Complexity: O(1)
    public static int bsIterative(int[] arr,int target){
        int low = 0;
        int high = arr.length - 1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return -1;
    }

    //BS Recursive // Time Complexity: O(log n) , Space Complexity: O(log n)
    public static int bsRecursive(int[] arr,int target,int low,int high){

        int mid = low + (high-low)/2;

        if(low > high){
            return -1;
        }

        if(arr[mid] == target){
            return mid;
        }else if(arr[mid] > target){
            return bsRecursive(arr, target, low, mid - 1);
        }else{
            return bsRecursive(arr, target, mid + 1, high);
        }

    }

    public static int lowerBound(int[] arr,int key){
        
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;  // always keep such answer when applying BS

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] >= key){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans; 
    }

    public static int upperBound(int[] arr,int key){

        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;  // always keep such answer when applying BS

        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] > key){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int searchInsertPos(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int findFloor(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int floor = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if (arr[mid] > key) {
                high = mid - 1;
            }
            else{ //equality is checked here cause in this case floor is updated
                floor = arr[mid]; 
                low = mid + 1;
            }
        }
        

        return floor;
    }

    public static int findCeil(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int ceil = -1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if (arr[mid] >= key) { // equality is checked here cause in this case ceil is updated
                ceil = arr[mid];
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        

        return ceil;
    }

    public static int[] searchRange(int[] arr, int target) { //first and last occurence using standard BS
        int first = findFirst(arr, target);
        if(first == -1) return new int[]{-1,-1}; //saves logarithmic of time coz if first occurence doesnt existsthen last also wont
        int last = findLast(arr, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) { 
                ans = mid;
                high = mid - 1;   // move left
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) { 
                ans = mid;
                low = mid + 1;    // move right
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int countOccurence(int[] arr, int target) { //subract first and last occurence to count total occurences
        int first = findFirst(arr, target);
        if(first == -1) return 0; //saves logarithmic of time coz if first occurence doesnt existsthen last also wont
        int last = findLast(arr, target);
        int occurences = last - first + 1; 
        return occurences;
    }

    public static int[] searchRange_using_LB_UB(int[] arr, int target) { //USING LB na dUB
        int first = lowerBound(arr, target);

        // If target not present
        if (first == arr.length || arr[first] != target) {
            return new int[]{-1, -1};
        }

        int last = upperBound(arr, target) - 1;

        return new int[]{first, last};
    }



    public static void main(String[] args){
        int[] arr = {3, 4, 4, 7, 8, 10};

        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println("");

        int target = 4;

        //int num = bsIterative(arr, target);

        //int num = bsRecursive(arr, target, 0, arr.length - 1);

        int key = 1;

        //int num = lowerBound(arr, key);

        //int num = upperBound(arr, key);

        //int num = searchInsertPos(arr, key);

        //int num = findFloor(arr,key);

        //int num = findCeil(arr,key);

        //System.out.println(num);
        //int[] res = searchRange(arr,target);

        //int[] res = searchRange_using_LB_UB(arr,target);

        int occurences = countOccurence(arr,target);
        System.out.println(occurences);

        // for(int x : res){
        //     System.out.print(x + " ");
        // }
        // System.out.println("");


    }

}