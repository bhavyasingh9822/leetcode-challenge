class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[2];
        int minDiff = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i= 0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum < target) j++;
                else if(sum > target) k--;
                else return sum;

                int diffFromTarget = Math.abs(sum - target);
                if(diffFromTarget < minDiff){
                    resultSum = sum;
                    minDiff = diffFromTarget;
                }
            }
        }
        return resultSum;
    }
}