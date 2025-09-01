class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2]; //each row has two cols: pos and speed
        for(int i = 0; i < n; i++){
            pairs[i][0]  = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs,(a,b) -> Integer.compare(b[0],a[0]));
        //sort in desc order of pos (1st: near target)
        //If the time(car nearest to target) > time(behind), fleet occurs 
        //so start the prevTime calc from the car nearest to the target
        double prevTime = (double)(target - pairs[0][0])/pairs[0][1];
        int fleet = 1;// car reaches destination alone
        for(int i = 1; i < n; i++){
            double currTime = (double)(target - pairs[i][0])/pairs[i][1];
            if(currTime > prevTime){
                fleet++;//if curr is slow, prev joins its speed => fleet
                prevTime = currTime;
            }
        }
        return fleet;
    }
}