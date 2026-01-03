class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long A = 6, B = 6; //For nrow = 1
        for(int i = 2; i <= n; i++){
            long newA = (2*A + 2*B) % MOD;
            long newB = (2*A + 3*B) % MOD;
            A = newA;
            B = newB;
        }

        return (int) ((A+B)%MOD);
        /*Pattern A(1) -> ABC all diff colors || B(2) -> ABA 1st & last same
        Followed by R  G  B 
        (ABC 
         ABC) -> newA
        G B R 
        B R G

        (ABC 
         ABA) -> newB
        G R G
        G B G

        Followed by R G R
        (ABA 
         ABC) -> newA
        G R B
        B R G

        (ABA 
         ABA) -> newB
        G R G
        G B G
        B R B*/
    }
}