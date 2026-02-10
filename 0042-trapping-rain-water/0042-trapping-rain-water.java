class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        //if somewhere behind taller block exists => left can hold water
        // |||y for right frwd
        while(l < r){
            if(height[l] < height[r]){ //if small check if capable of holdin H2O
                l++;
                leftMax = Math.max(leftMax,height[l]);
                res += leftMax - height[l];
            }
            else{
                r--;
                rightMax = Math.max(rightMax,height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}