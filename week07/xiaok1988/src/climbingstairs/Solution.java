package climbingstairs;

class Solution {
    public int climbStairs(int n) {
        int f0 = 0, f1 = 1, fn = 0;
        for (int i = 0; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return f0;
    }
}
