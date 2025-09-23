class Solution {
    public int majorityElement(int[] nums) {
        /*T(n) = O(nlogn)
        S(n) = O(logn)*/
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}