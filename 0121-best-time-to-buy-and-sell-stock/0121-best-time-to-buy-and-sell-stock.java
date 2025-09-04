class Solution {
    /*Inintialize maxP as 0 and minPrice from arr
    T(n) = O(n)
    S(n) = O(1)*/
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minPrice = prices[0];
        for(int sell : prices){
            maxP = Math.max(maxP, sell - minPrice);
            minPrice = Math.min(minPrice, sell);
        }
        return maxP;
    }
}