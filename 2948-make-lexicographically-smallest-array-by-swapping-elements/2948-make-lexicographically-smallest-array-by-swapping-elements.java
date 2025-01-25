// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
//     }
// }
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {


        int len = nums.length;


        for(int i = 0; i < len - 1; )
        {
            boolean flag = true;

            while(flag)
            {
                int val = nums[i], pos = i;

                for(int j = i+1; j < len; j++)
                {
                    if(Math.abs(val - nums[j]) <= limit && val > nums[j])

                    {
                        val = nums[j];
                        pos = j;
                    }
                }


                int dup = nums[i];
                nums[i] = nums[pos];
                nums[pos] = dup;


                if(pos == i)
                {
                    flag = false;
                }
            }


            i++;
        }


        return nums;
    }
}