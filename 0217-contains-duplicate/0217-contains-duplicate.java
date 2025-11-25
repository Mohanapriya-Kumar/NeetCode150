class Solution {
    /*Using HashSet
    T(n) = O(n)
    S(n) = O(n)*/
    //Anything related to duplicate/unique can use HashSet
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}