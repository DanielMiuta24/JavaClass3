package algorithms;

public class Knapsack01 {
    public static int maxValue(int[] w, int[] v, int cap) {
        int n = w.length;
        int[][] dp = new int[n+1][cap+1];
        for (int i = 1; i <= n; i++) {
            for (int c = 0; c <= cap; c++) {
                dp[i][c] = dp[i-1][c];
                if (w[i-1] <= c) dp[i][c] = Math.max(dp[i][c], dp[i-1][c - w[i-1]] + v[i-1]);
            }
        }
        return dp[n][cap];
    }
}
