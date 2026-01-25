
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

    public static void main(String[] args){
        int[] arr = {2, 3, 4, 10, 40, 50, 60, 70, 80, 90 , 100};

        int target = 90;

        //int num = bsIterative(arr, target);

        //int num = bsRecursive(arr, target, 0, arr.length - 1);

        int key = 5;

        //int num = lowerBound(arr, key);

        int num = upperBound(arr, key);

        System.out.println(num);
    }

}