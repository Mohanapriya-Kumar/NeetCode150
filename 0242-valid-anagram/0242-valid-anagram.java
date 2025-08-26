class Solution {
    /*Using simple ++ & --
    T(n) = O(m+n) for(..m) for(..n)
    S(n) = O(1) const arr[26]
    Logic: ++ char freq for occurrrence in s then -- for corresponding t*/
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26]; //for 26 alphabets
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++; //-'a' to convert ascii to index from 0
        }
        for(int i = 0; i < t.length(); i++){
            freq[t.charAt(i) - 'a']--;
        }
        for(int i : freq){
            if(i != 0) return false;
        }
        return true;
    }
}