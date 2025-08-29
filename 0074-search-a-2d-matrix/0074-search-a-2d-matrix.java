class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nrow = matrix.length, ncol = matrix[0].length; 
        int l = 0, r = nrow*ncol - 1;
        while(l <= r){
            int m = l + (r-l)/2;
                /*     col : for 1D -> 2D
                        0    1    2    3 
                r 0   [0]  [1]  [2]  [3]
                r 1   [4]  [m=5]  [6]  [7]
                r 2   [8]  [9]  [10] [11]
            */
            int row = m/ncol, col = m%ncol;//quotient is the row and remainder is the col
            if(target < matrix[row][col]){
                r = m - 1;
            }
            else if(target > matrix[row][col]){
                l = m + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}