class Solution {
    static int countWaysUtil(int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		 int dp[][] = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);
        return countWaysUtil(m, n, dp);
	}
    
}