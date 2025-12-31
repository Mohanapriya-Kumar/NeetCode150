class Solution {
    public int myAtoi(String s) {
        int index = 0, n = s.length();
        long result = 0;
        int sign = 1;
        while(index < n && s.charAt(index) == ' '){
            index++;
        }
        if(index < n && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }
        while(index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';
            result = result*10 + digit;
            if(sign == 1 && result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && -result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) result*sign;
    }
}