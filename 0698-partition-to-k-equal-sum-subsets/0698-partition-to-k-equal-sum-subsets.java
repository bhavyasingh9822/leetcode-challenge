class Solution {
    int maxLen = 0;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i:nums)sum+=i;
        if(sum%k!=0)return false;
        this.maxLen = sum/k;

        for(int i=0;i<nums.length;i++)nums[i]*=-1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)nums[i]*=-1;
        if(nums[0]>sum/k)return false;

        return helper(0, nums, new int[k]);
    }
    public boolean helper(int start, int[] nums, int arr[]){
        if(start==nums.length)return true;

        boolean x = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+nums[start]>maxLen)continue;
            if(arr[i]>maxLen)break;
            int j = i;
            while(--j>=0)if(arr[i]==arr[j])break;
            if(j!=-1)continue;

            arr[i]+=nums[start];
            x |= helper(start+1, nums, arr);
            arr[i]-=nums[start];
        }
        return x;
    }
}