import java.util.*;

class PrefixSum{
    public static int pivotIndexUnderstanding(int[] nums) {
       
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 0;
        for(int i = 1;i < n;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        suffix[n-1] =0;
        for(int i = n-2;i >=0;i--){
            suffix[i] = suffix[i+1] + nums[i+1];
        }

        for(int i = 0;i < n;i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
        }

        return -1;

    }

    public static int pivotIndexOptimal(int[] nums) {
        
        int totalSum = Arrays.stream(nums).sum();
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        // System.out.println(pivotIndexUnderstanding(nums));
        System.out.println(pivotIndexOptimal(nums));

    }

}