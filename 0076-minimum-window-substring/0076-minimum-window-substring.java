class Solution {
    public String minWindow(String s, String t) {
        /*Sliding Window
        T(n) = O(s + t)
        S(n) = O(k)*/
        Map<Character, Integer> targetCount = new HashMap<>();
        for(char c : t.toCharArray()){
            targetCount.put(c,targetCount.getOrDefault(c,0) + 1);
        }
        int reqd = targetCount.size(), found = 0;//reqd cannot be t.length() AABC = 3 not 4
        int l = 0, r = 0;
        int[] ans = {-1,0,0};//width,l,r
        Map<Character, Integer> windowCount = new HashMap<>();
        while(r < s.length()){
            char c = s.charAt(r); 
            windowCount.put(c,windowCount.getOrDefault(c,0)+1);
            if(targetCount.containsKey(c) && targetCount.get(c).equals(windowCount.get(c))){
                found++;
            }
            while(l <= r && reqd == found){ //ans updated if req==found
                if(ans[0] == -1 || (r - l + 1) < ans[0]){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                c = s.charAt(l);
                windowCount.put(c, windowCount.get(c) - 1);//remove from left in window
                if(targetCount.containsKey(c) && windowCount.get(c) < targetCount.get(c)){
                    //aft removing from left check if target has c but window doesnt
                    found--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}
/*Build the target map

Loop over t and fill targetCount with required frequencies.

Set reqd = targetCount.size() (unique characters we need to satisfy).

Initialize

found = 0, l = 0, r = 0, ans = {-1,0,0}, windowCount = {}.

Outer loop — expand right until end of s

while (r < s.length()) {

Let c = s.charAt(r).

Increment windowCount[c] (we added c to the window).

If c is in targetCount and windowCount[c] == targetCount[c], then we reached the required count for that unique character → found++.

(We only increment found when a required character's count goes from below requirement to equal requirement.)

Now check the inner loop (shrink phase) while the window is valid:

while (l <= r && found == reqd) { — as long as all required characters are satisfied, try to shrink.

Inner loop — shrink from the left to minimize

We are in a valid window because found == reqd.

Record the current window if it’s smaller than previously saved:

If ans[0] == -1 || (r - l + 1) < ans[0] → set ans = {r-l+1, l, r}.

Remove the leftmost character:

leftChar = s.charAt(l)

Decrement windowCount[leftChar].

Check if removal broke a requirement:

If leftChar is required (targetCount.containsKey(leftChar)) and windowCount[leftChar] < targetCount[leftChar], then we no longer satisfy that unique character → found--.

Once found decreases, the inner loop condition found == reqd becomes false and we exit the shrink loop.

Move l forward (l++) — window is now smaller.

If after incrementing l we still have found == reqd, we repeat shrinking again.

Continue expanding

After we exit the inner loop (window is no longer fully valid), move r++ to expand again and try to regain validity later.

Repeat until r has traversed the entire string.

Return result

If ans[0] == -1 → no valid window was found → return "".

Else return s.substring(ans[1], ans[2] + 1) → the smallest valid window recorded.*/