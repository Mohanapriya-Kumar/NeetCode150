class Solution {
    public int largestRectangleArea(int[] heights) {
        /*Logic: if empty st =>push, if not: i == n or st > curr => pop
        h = pop, w = i/ i - peek - 1
        T(n) = O(n)
        S(n) = O(n)*/
        int maxArea = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++){//i == n at last to flush st
        while(!stack.isEmpty() && (i == n || heights[stack.peek()] >= heights[i])){
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, h*w);
        }
            stack.push(i);
        }
        return maxArea;
    }
}