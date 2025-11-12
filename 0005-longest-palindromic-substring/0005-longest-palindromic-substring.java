class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = findPal(s,i,i); //odd len palidrome centered at i
            int len2 = findPal(s,i,i+1); //even len palidrome centered at i
            int len = Math.max(len1,len2);
            if(len >= (end - start + 1)){
                start = i - (len-1)/2;
                end = i + (len/2);//because end index in s.substring is  exclusive
            }
        }
        return s.substring(start, end+1);
    }
        private int findPal(String s, int left, int right){ //expand from centre
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            return right - left - 1; //remove one extra iteration took for checking
        }
}