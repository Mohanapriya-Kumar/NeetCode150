class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder txt = new StringBuilder();
        String S = s.toLowerCase();
        for(char c : S.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                txt.append(c);
            }
        }
        String clean = txt.toString();
        String rev = txt.reverse().toString();
        return clean.equals(rev);
    }
}