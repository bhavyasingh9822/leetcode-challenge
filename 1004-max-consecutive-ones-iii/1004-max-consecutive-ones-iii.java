class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, n = nums.length;
        int longest = 0;
        for(int right = 0; right < n; ++right){
            if(nums[right] == 0) zeros++;
            if(zeros > k){
                if(nums[left] == 0) zeros--;
                left++;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}