class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        
        // Convert primitive array to Integer[] for sorting using Collections
        Integer[] tempArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(tempArr); // Sort the array
        
        // Convert back to int[]
        for (int i = 0; i < n; i++) {
            nums[i] = tempArr[i];
        }

        // Initialize dp and hash arrays
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            hash.set(i, i);  // Every element points to itself initially
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && dp.get(prev) + 1 > dp.get(i)) {
                    dp.set(i, dp.get(prev) + 1);
                    hash.set(i, prev);
                }
            }
        }

        // Find the index of the maximum value in dp
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp.get(i) > dp.get(maxIndex)) {
                maxIndex = i;
            }
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        result.add(nums[maxIndex]);

        while (hash.get(maxIndex) != maxIndex) {
            maxIndex = hash.get(maxIndex);
            result.add(nums[maxIndex]);
        }

        Collections.reverse(result);
        return result;
    
    }
}