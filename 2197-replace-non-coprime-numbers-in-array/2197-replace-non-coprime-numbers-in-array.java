class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        /*Stack approach
        T(n) = O(nlogC) C = max possible num
        S(n) = n*/
        int[] stack = new int[n];
        int top = -1;
        for(int num : nums){
            while(top != -1){
                int x = gcd(stack[top],num);
                if(x == 1) break;
                num *= stack[top--]/x;
            }
            stack[++top] = num;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= top; i++){
            res.add(stack[i]);
        }
        return res;
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}