class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        } //skip trailing spaces first
        while(j >= 0 && s.charAt(j) != ' '){
            count++;
            j--;
        }
        return count;

    }
}