class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){//the order of elements occuring is incing(left side)
                if(nums[left] <= target && target < nums[mid]){//target is between left & mid
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{ // right side is sorted
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}