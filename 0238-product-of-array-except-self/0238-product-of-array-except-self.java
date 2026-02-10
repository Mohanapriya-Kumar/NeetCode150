class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* Prefix * Postfix for num[i]
        T(n) = O(n);
        S(n) = O(n) for res arr
        */
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i-1] * nums[i-1];
        }
        int postfix = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}