class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] merged = new int[m + n];
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                merged[k++] = nums1[i++];
            }
            else{
                merged[k++] = nums2[j++];
            }
        }
        while(i < m){
            merged[k++] = nums1[i++];
        }
        while(j < n){
            merged[k++] = nums2[j++];
        }
        int tot = merged.length;
        if(tot % 2 == 0){
            return ((merged[(tot/2) - 1]) + (merged[tot/2])) / 2.0;
        }
        else{
            return  merged[tot/2];
        }
    }
}