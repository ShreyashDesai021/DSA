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


    public static void main(String[] args){
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // System.out.println(maxSubArray(nums));

        int[] nums = {1, 2, 3, -4, 5};
        System.out.println(smallestSumSubarray(nums));

    }
}