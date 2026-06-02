class Kadane{

    public static int maxSubArray(int[] nums) {
        
        int bestEnding = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0;i < nums.length;i++){

            int v1 = bestEnding + nums[i];
            int v2 = nums[i];

            bestEnding = Integer.max(v1,v2);

            maxSum = Integer.max(maxSum,bestEnding);

        }

        return maxSum;
    }

    public static int smallestSumSubarray(int nums[]) {
        // your code here
        int bestEnding = 0;
        int minSum = Integer.MAX_VALUE;

        for(int i = 0;i < nums.length;i++){

            int v1 = bestEnding + nums[i];
            int v2 = nums[i];

            bestEnding = Integer.min(v1,v2);

            minSum = Integer.min(minSum,bestEnding);

        }

        return minSum;
    }

    public static int maxProduct(int[] nums) {
        
        int minEnding = nums[0];
        int maxEnding = nums[0];
        int maxProd = nums[0]; // dont consider it Integer.MIN_VALUE as it will fail the case where input is nums = {-2}

        for(int i = 1;i < nums.length;i++){

            int v1 = nums[i];
            int v2 = minEnding * nums[i];
            int v3 = maxEnding * nums[i];

            minEnding = Integer.min(v1,Integer.min(v2,v3));
            maxEnding = Integer.max(v1,Integer.max(v2,v3));

            maxProd = Integer.max(maxProd,maxEnding);

        }

        return maxProd;

    }

    public static int maxAbsoluteSum(int[] nums) {
        
        int minSum = 0;
        int maxSum = 0;
        int maxAbsSum = 0;

        for(int i = 0;i < nums.length;i++){
            
            int v1 = minSum + nums[i];
            int v2 = nums[i];

            minSum = Integer.min(v1,v2);

            int v3 = maxSum + nums[i];
            int v4 = nums[i];

            maxSum = Integer.max(v3,v4);

            maxAbsSum = Integer.max(maxAbsSum,Integer.max(maxSum,Math.abs(minSum))); // dont forget to write previous maxAbsSum while comparing nigga

        }

        return maxAbsSum;
    }

    public static void main(String[] args){
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // System.out.println(maxSubArray(nums));

        // int[] nums = {1, 2, 3, -4, 5};
        // System.out.println(smallestSumSubarray(nums));
        
        // int[] nums = {2, 3, -2, 4};
        // System.out.println(maxProduct(nums));

        int[] nums = {1, -3, 2, 1, -1};
        System.out.println(maxAbsoluteSum(nums));

    }
}