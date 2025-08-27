class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
     c0 c1 c2 | c3 c4 c5 | c6 c7 c8
   +-----------+-----------+-----------+
r0 |     0     |     1     |     2     |
r1 |     0     |     1     |     2     |
r2 |     0     |     1     |     2     |
   +-----------+-----------+-----------+
r3 |     3     |     4     |     5     |
r4 |     3     |     4     |     5     |
r5 |     3     |     4     |     5     |
   +-----------+-----------+-----------+
r6 |     6     |     7     |     8     |
r7 |     6     |     7     |     8     |
r8 |     6     |     7     |     8     |
   +-----------+-----------+-----------+
        T(n) = n^2
        S(n) = n*/
        //logic: create 3 arrays, if . continue.. get val = value - '1', 1 becomes 0 etc.. 
        //shift left 00000001 by val for bit masking & gives > 1 if = else & gives 0 
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.') continue;
                int val = board[r][c] - '1';
                if((rows[r] & (1 << val)) > 0 || (cols[c] & (1 << val)) > 0 || (squares[(r/3)*3 + c/3] & (1 << val)) > 0) return false;
                rows[r] |= (1 << val);
                cols[c] |= (1 << val);
                squares[(r/3)*3 + c/3] |= (1 << val);
            }
        }
        return true;
    }
}