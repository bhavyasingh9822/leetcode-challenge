class Solution {
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        
        // Initialize the dp array with -1
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return uniquePathsUtil(n - 1, m - 1, obstacleGrid, dp);
    }

    private int uniquePathsUtil(int i, int j, int[][] grid, int[][] dp) {
        if (i >= 0 && j >= 0 && grid[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int up = uniquePathsUtil(i - 1, j, grid, dp);
        int left = uniquePathsUtil(i, j - 1, grid, dp);

        return dp[i][j] = up + left;
    }
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    // }
}