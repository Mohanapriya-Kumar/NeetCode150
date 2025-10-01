class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        /*Simply add to drunk and empty then exchange to get back numB and empty
        T(n) = O(log(n))
        S(n) = O(1)*/
        int drunk = 0;
        int empty = 0;
        while(numBottles > 0){
            drunk += numBottles;
            empty += numBottles;

            numBottles = empty/numExchange;
            empty = empty % numExchange;
        }
        return drunk;
    }
}