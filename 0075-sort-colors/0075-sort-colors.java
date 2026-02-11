class Solution {
    public void sortColors(int[] nums) {
        /*Dutch National Flag Algorithm
        T(n) = O(n)
        S(n) = O(1)*/
        int n = nums.length;
        int l = 0, m = 0, h = n - 1;
        while(m <= h){
            if(nums[m] == 0){
                swap(nums, m, l);
                l++;
                m++;
            }
            else if(nums[m] == 1){
                m++;
            }
            else{
                swap(nums, m, h);
                h--;
            }
        }
    }
    private void swap(int nums[], int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}