class Solution {
    public int characterReplacement(String str, int k) {
        /*Need to maintain both charaters and its count
        T(n) = O(n) n - len of s
        S(n) = O(m) m - no of unique chars*/
         int[] count = new int[26];
        int left = 0, right = 0;
        int res = 0;
        int maxf = 0;

        while(right < str.length()){
            count[str.charAt(right)-'A']++;
            maxf = Math.max(maxf, count[str.charAt(right)-'A']);
            while((right - left + 1 - maxf) > k){//width - longest(crt) = wht I can change
                count[str.charAt(left) - 'A']--;//shrink from left
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
