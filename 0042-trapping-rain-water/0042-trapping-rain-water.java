class Solution {
    public int trap(int[] height) {
        /*Two ptr approach
        T(n) = O(n)
        S(n) = O(1)*/
        //logic l < r => l++ res+=leftMax-height[l] simly for r
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while(l < r){
            if(height[l] < height[r]){
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
