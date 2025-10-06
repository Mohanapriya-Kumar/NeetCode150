class Solution {
    public void rotate(int[] nums, int k) {
        /*T(n) = O(n)
        S(n) = O(1)*/
        int n = nums.length;
        k = k % n;
        rev(nums, 0, n - k - 1);
        rev(nums, n - k, n - 1);
        rev(nums, 0, n - 1);
    }
    private void rev(int[] nums, int l, int r){
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
        ///*T(n) = O(n)
        // S(n) = O(n)*/
        // int n = nums.length;
        // k = k % n;
        // int[] rotated = new int[n];
        // for(int i = 0; i < n; i++){
        //     rotated[(i + k) % n] = nums[i]; 
        // }
        // for(int i = 0; i < n; i++){
        //     nums[i] = rotated[i];
        // }