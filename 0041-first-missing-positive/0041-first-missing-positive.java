class Solution {
    public int firstMissingPositive(int[] nums) {
        //correct position for a value is v - 1 (1,2,3..) for 1 index is 0
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){//no-1=index of that no
                //swap corr index no with num[i]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex]; 
                nums[correctIndex] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return i+1; //the supposed number
            }
        }
        //evythg is crt => 0,1,2.. so 3 is the least missing no.
        return n+1;
    }
}