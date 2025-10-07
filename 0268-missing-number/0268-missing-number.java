class Solution {
    public int missingNumber(int[] nums) {
        /*T(n) = O(n)
        S(n) = O(1)*/
        int sum = 0;
        int n = nums.length;
        for(int num : nums){
            sum += num;
        }
        return (n*(n+1)/2) - sum;
    }
}