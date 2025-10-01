class Solution {
    public boolean check(int[] nums) {
        /*T(n) = O(n)
        S(n) = O(1)*/
        int count = 0;//rotated elements count eg: 4 5 1 2 3 rotation at single pivot 
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                count++;
            }
        }
        if(count == 0) return true;
        else if(count == 1 && nums[0] >= nums[nums.length - 1]) return true;
        return false;
       
    }
}