class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            if(freq.containsKey(num) && freq.get(num) >= 1) return true;
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        return false;
    }
}