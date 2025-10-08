class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*T(n) = O(n)
        S(n) = O(1)*/
        int res = 0;
        for(int num : nums){
            res ^= num;
        }
        return res;
    }
}