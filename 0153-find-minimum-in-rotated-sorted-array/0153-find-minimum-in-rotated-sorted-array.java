class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]){
            //mismatch actually mid < high if not smlr elements r to the right
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return nums[low]; //or nums[high]
    }
}