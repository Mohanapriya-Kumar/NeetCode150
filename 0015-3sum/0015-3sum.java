class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*Two pointer approach
        T(n) = O(n^2)
        S(n) = O(k) constant
        */
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];//checking if nums[i]+nums[l]+nums[r]=0
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left]==nums[left+1]) left++; //make sure l<r
                    while(left < right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
    }
}