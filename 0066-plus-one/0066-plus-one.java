class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] < 9){ //check if +1/carry can be put on this digit directly
                digits[i]++;
                return digits;
            }
            digits[i] = 0; //digit is 9, it bcms 0 and carry goes to left digit
        }
        int res[] = new int[n+1]; //all digits are 9 need one more place
        res[0] = 1; //other digits = 0
        return res;
    }
}