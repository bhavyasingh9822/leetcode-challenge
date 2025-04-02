class Solution {
    public int minFallingPathSum(int[][] matrix) {
         int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++)
        {
            dp[0][i] = matrix[0][i];
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up = matrix[i][j] + dp[i - 1][j];
                int ld = Integer.MAX_VALUE,rd = Integer.MAX_VALUE;
                if(j<n-1)
                {
                    ld = matrix[i][j] + dp[i-1][j+1];
                }
                if( j>=1)
                {
                    rd = matrix[i][j] + dp[i-1][j-1];
                }
                dp[i][j] = Math.min(up,Math.min(ld,rd));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int num:dp[n-1])
        {
            ans = Math.min(num,ans);
        }
        return ans;
    }
}