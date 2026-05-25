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

    public void mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; //last element's index in num1
        int j = n - 1; //last element's index in num2
        int k = m + n - 1; // last index in num1 (i.e of extra 0's not the elements)

        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }   
    
    }

    public static void main(String[] args){
        int[] arr1 = {12,7,2,15};
        int target = 19;
        //System.out.println(Arrays.toString(TwoSum(arr1, target)));

        int[] arr2 = {1,1,2,2,2,3,3};
        //System.out.println(removeDuplicates(arr2));

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;  
        TwoPointer obj1 = new TwoPointer();
        obj1.mergeTwoSortedArrays(nums1,m,nums2,n);

        System.out.println(Arrays.toString(nums1));

    }
}

