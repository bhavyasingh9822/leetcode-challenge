import java.util.Stack;

public class Solution {
    public int findMax(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : arr[i];
            while (!stack.isEmpty() && curr < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + dp[i - 1][j];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int maxRectangle = 0;
        for (int i = 0; i < n; i++) {
            maxRectangle = Math.max(maxRectangle, findMax(dp[i]));
        }

        return maxRectangle;
    
    }
}