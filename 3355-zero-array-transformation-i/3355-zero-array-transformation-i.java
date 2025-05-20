class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
         int n = nums.length;
        int[] diff = new int[n + 1]; 

        for (int[] query : queries) {
            int i = query[0], j = query[1];
            diff[i]--;
            if (j + 1 < n) {
                diff[j + 1]++;
            }
        }

        int currDecrement = 0;
        for (int i = 0; i < n; i++) {
            currDecrement += diff[i];
            nums[i] += currDecrement;
            if (nums[i] > 0) {
                return false; 
            }
        }

        return true;
    }
}