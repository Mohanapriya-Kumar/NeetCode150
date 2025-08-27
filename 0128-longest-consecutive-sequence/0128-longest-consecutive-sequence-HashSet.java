class Solution {
    public int longestConsecutive(int[] nums) {
        /*Any sort Array requiring problem can use HashSet
        T(n) = O(n)
        S(n) = 1*/
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int maxCount = 0;
        for(int num : set){
            if(!set.contains(num - 1)){ //start only if it is the start
                int curr = num;
                int count = 1;
                while(set.contains(curr + 1)){
                    curr++;
                    count++;
                }
                maxCount = Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}