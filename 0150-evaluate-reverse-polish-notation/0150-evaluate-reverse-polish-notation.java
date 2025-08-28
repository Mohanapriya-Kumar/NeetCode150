class Solution {
    public int evalRPN(String[] tokens) {
        /* Using Stack Approach
        T(n) = O(n)
        S(n) = O(n)*/
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }
            else if(s.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }
            else if(s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}