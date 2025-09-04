class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*Sliding Window Approach
        T(n) = O(n) n = len of the string, m = tot no of unique chars
        S(n) = O(m)*/
        int l = 0;
        int maxLength = 0;
        Set<Character> seen = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            while(seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
        
    }
}

