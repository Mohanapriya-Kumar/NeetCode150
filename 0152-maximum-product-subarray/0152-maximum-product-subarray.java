class Solution {
    public int maxProduct(int[] nums) {
        /*T(n) = O(n)
        S(n) = O(1)*/
        int minSoFar = nums[0];
        int maxSoFar = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(curr*maxSoFar,curr*minSoFar));
            minSoFar = Math.min(curr, Math.min(curr*maxSoFar,curr*minSoFar));
            maxSoFar = tempMax;
            res = Math.max(res,maxSoFar);
        }
        return res;
    }
}