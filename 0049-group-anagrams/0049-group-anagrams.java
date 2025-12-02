class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*Using HashMap to store key(pattern of 0's & 1's that can produce Ansgrams)
        T(n) = O(m*n) m = no. of s in strs, n = length of longest s: 2 loops
        S(n) = O(m) Hashet of no. of strs
        */
        //Logic: First find key of each s then put in map if absent then add s to the key(List)
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}