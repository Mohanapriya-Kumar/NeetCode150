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
        int[] boxes = new int[9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int digit = board[row][col] - '1';
                int mask = 1 << digit;
                int boxIndex = (row / 3) * 3 + (col / 3);
                if ((rows[row] & mask) != 0 ||
                    (cols[col] & mask) != 0 ||
                    (boxes[boxIndex] & mask) != 0) {
                    return false;
                }
                rows[row] |= mask;
                cols[col] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true; 
    }
}