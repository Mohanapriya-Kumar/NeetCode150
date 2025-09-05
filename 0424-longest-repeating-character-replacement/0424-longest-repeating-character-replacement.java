class Solution {
    public int characterReplacement(String str, int k) {
         int[] occurance = new int[26];
        int left = 0, right = 0;
        int maxLen = 0;
        int maxOccurrance = 0;

        while(right < str.length()){
            maxOccurrance = Math.max(maxOccurrance, ++occurance[str.charAt(right)-'A']);
            while(right-left+1 - maxOccurrance > k){
                occurance[str.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen,right-left+1);
            right++;
        }

        return maxLen;
    }
}
