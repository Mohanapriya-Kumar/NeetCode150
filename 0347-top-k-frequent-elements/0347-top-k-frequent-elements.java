class Solution {
    public int[] topKFrequent(int[] nums, int k) {//bucket sort
        /*Storing map count for num:freq mapping, Array freq with each index value: AL of elements whose count = i(index of freq Array)
        T(n) = O(n);
        S(n) = O(n)*/
        //logic retrive from freq in reverse using 2 for loops
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) { //num and corr freq
            freq[entry.getValue()].add(entry.getKey()); //go to array and its AL
        }
        int index = 0;
        int[] res = new int[k];
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}