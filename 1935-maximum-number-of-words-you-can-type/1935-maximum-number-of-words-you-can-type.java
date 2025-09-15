class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        /*T(n) = O(m + n)
        S(n) = O(m + n) n = no.of characters in the text, m = no of broken words*/
        String[] words = text.split(" ");
        int count = 0;
        for(String word : words){
            boolean canType = true;
            for(char c : brokenLetters.toCharArray()){
                if(word.indexOf(c) != -1){
                    canType = false;
                    break;
                }
            }
            if(canType) count++;
        }
        return count;
    }
}