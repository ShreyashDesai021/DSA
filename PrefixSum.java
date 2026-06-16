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

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1); // for possibility that complete array sum is k and sum - k = 0

        for(int i = 0;i < nums.length;i++){
            sum += nums[i];

            int question = sum - k; // named variable as question, becoz this we will be asking to themap have u seen this before

            int freq = map.getOrDefault(question, 0); 

            if(freq > 0){
                res += freq; // we are not doing res++ and instead doing += freq becoz there can be multiple instance of that sum, whhich tell more than one subarray ended over there, so we should consider them all
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        // System.out.println(pivotIndexUnderstanding(nums));
        //System.out.println(pivotIndexOptimal(nums));

        int[] nums2 = {3, 4, 7, 2, -3, 1, 4, 3};
        int k = 7;
        System.out.println(subarraySum(nums2, k));

    }

}