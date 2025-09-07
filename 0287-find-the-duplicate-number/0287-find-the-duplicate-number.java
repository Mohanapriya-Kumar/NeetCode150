class Solution {
    public int findDuplicate(int[] nums) {
        /*Important Note: The Array has n+1 elements in range [1,n] so vals can be used as index to convert it to Floyd's Cycle Detection Problem
        T(n) = O(n)
        S(n) = O(1)*/
        int slow = 0, fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break; 
            //somwhere in the cycle need not necessarily be the entrance of the cycle;
        }
        int slow2 = 0;//dist from 0 by s2 == by s1 from meeting to entrance
        while(true){
            slow2 = nums[slow2];
            slow = nums[slow];
            if(slow == slow2){
                return slow;
            }
        }
    }
}