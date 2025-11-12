class Solution {
    public int maxSubArray(int[] nums) {
        /*Kadane's Algorithm
        T(n) = O(n)
        S(n) = O(1)*/
        int maxSum = nums[0];
        int currSum = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++){
            currSum = Math.max(nums[i], currSum + nums[i]); //cumulative || invdividual (if -ve)
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}