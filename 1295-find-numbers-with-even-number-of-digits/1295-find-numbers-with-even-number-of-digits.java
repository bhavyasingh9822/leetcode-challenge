class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int x : nums)
            if (((int)Math.log10(x) + 1) % 2 == 0)
                res++;
        return res;
    }
}