class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0; //base case must else count != 0
        Arrays.sort(nums);
        int count = 1;
        int maxCount = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue; //dont care abt duplicates
            else if(nums[i] == nums[i-1] + 1) count++;
            else if(nums[i] != nums[i-1] + 1) count = 1; //start a new Streak
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}