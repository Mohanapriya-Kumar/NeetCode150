class Solution {
    public int characterReplacement(String s, int k) {
        /*Need to maintin both charaters and its count
        T(n) = O(n) n - len of s
        S(n) = O(m) m - no of unique chars*/
        int[] count = new int[26];
        int l = 0, maxf = 0, res = 0;
        for(int r = 0; r < s.length(); r++){
            count[s.charAt(r) - 'A']++;
            maxf = Math.max(maxf, count[s.charAt(r) - 'A']);
            if((r - l + 1) - maxf > k){//width - longest(crt) = wht I can change
                count[s.charAt(l) - 'A']--; //shrink from left
                l++;
            }
            res = Math.max(res, r - l + 1); 
        }
        return res;
    }
}