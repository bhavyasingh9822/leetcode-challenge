class Solution {
    private int solve(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i] + (i > 1 ? prev2 : 0);
            int nonPick = prev;
            int cur = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
    public int rob(int[] nums) {
         int n = nums.length;
        if (n == 1) return nums[0];

        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];

        for (int i = 0; i < n; i++) {
            if (i != 0) arr1[i - 1] = nums[i];
            if (i != n - 1) arr2[i] = nums[i];
        }

        return Math.max(solve(arr1), solve(arr2));
    }
}