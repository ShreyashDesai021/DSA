import java.util.*;

// When and where to use two pointer approach?
// 1. When we have to find a pair in an array which satisfies a condition.
// 2. When we have to find a triplet in an array which satisfies a condition.
// 3. When we have to find a subarray in an array which satisfies a condition.
// 4. When we have to find a subsequence in an array which satisfies a condition.
// 5. When we have to find a substring in a string which satisfies a condition.
// 6. When we have to find a subsequence in a string which satisfies a condition.
// 7. When we have to find a subarray in an array which satisfies a condition and the array is sorted.
// 8. When we have to find a subsequence in an array which satisfies a condition
// 9. When we have to find a substring in a string which satisfies a condition and the string is sorted.
// 10. When we have to find a subsequence in a string which satisfies a condition and the string is sorted. 

public class TwoPointer{
    public static int[] TwoSum(int[] arr,int target){
        
        Arrays.sort(arr); // sort allowed because we want to return the actual nums not indexes

        int i = 0;
        int j = arr.length - 1;

        while(i < j){ // (i < j) not (i <= j)
            int sum = arr[i] + arr[j];
            if(sum == target){
                return new int[]{arr[i], arr[j]};
            }
            else if(sum < target){
                i++;
            }
            else{ // sum > target
                j--;
            }
        }

        return new int[]{-1, -1};
    }

    public static int removeDuplicates(int[] arr){
       int i = 1; // coz 0th position will always be unique element
       int j = 1;

       while(j != arr.length){
            if(arr[j-1] != arr[j]){
                arr[i] = arr[j];
                i++;
                j++;
            }else{
                j++;
            }
       }  
       return i; // returning unique people
    }

    public static void main(String[] args){
        int[] arr1 = {12,7,2,15};
        int target = 19;
        //System.out.println(Arrays.toString(TwoSum(arr1, target)));

        int[] arr2 = {1,1,2,2,2,3,3};
        System.out.println(removeDuplicates(arr2));
    }
}

