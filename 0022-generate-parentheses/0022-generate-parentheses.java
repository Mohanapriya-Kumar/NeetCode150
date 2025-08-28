class Solution {
    public List<String> generateParenthesis(int n) {
        /*Using BackTracking
        T(n) = O(4^n/sqrt(n));
        S(n) = O(n)*/
        List<String> res = new ArrayList<>();
        backTrack(res,"",0,0,n);
        return res;
    }
    private void backTrack(List<String> res, String curr, int open, int close, int max){
        if(curr.length() == max*2){
            res.add(curr);
            return;
        }
        if(open < max){
            backTrack(res, curr+"(", open + 1, close, max);
        }
        if(close < open){
            backTrack(res, curr+")", open, close + 1, max);
        }
    }
}