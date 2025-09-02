class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*k = no. of bananas/hr 0<=k<=max(piles)
        T(n) = O(nlogm) n: no. elements in array, maximum no. bananas in the pile
        S(n) = O(1)*/
        int low = 1;//min k
        int high = 0;
        for(int pile : piles){
            high = Math.max(high,pile);

        }
        while(low < high){
            int mid = low + (high - low)/2;
            if(canEat(piles, h, mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
        //while terminates when low == high single value remains at last is returned
        //Binsearch returns mid bcuz we just need bool T/F here we need to minimize
    }
    private boolean canEat(int[] piles, int h, int k){
            long hrs = 0;
            for(int pile : piles){
                hrs += (int) Math.ceil((double)pile/k);
            }
            return hrs <= h;//can complete within h
        }
}