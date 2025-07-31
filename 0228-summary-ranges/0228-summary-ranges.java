class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        if(nums.length == 0) return answer;

        int start = 0;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] != nums[i-1]+1) {
                if(start == i-1) {
                    answer.add(String.valueOf(nums[start]));
                } else {
                    answer.add(nums[start] + "->" + nums[i-1]);
                }
                start = i;
            }
        }
        if(start == nums.length-1) {
            answer.add(String.valueOf(nums[start]));
        } else {
            answer.add(nums[start] + "->" + nums[nums.length-1]);
        }
        return answer;
    }
}