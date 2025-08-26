class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*Use HashMap to store num and its index
        T(n) = O(n)
        S(n) = O(n)*/
        //Logic: for num[i] see if target - num[i] is in map => return index i, index(y): map.get(y) else add to map
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int y = target - x;
            if (map.containsKey(y)) {
                return new int[] { i, map.get(y) };
            }
            map.put(nums[i], i);
        }
        return new int[] {};

    }
}