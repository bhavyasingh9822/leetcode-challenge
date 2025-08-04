class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> st = new HashSet<>();
        int i = 0 , cnt = 0;

        while(i < arr.length) {
            int j = i;
            while(j + 1 < arr.length && arr[j + 1] == arr[j]) {
                j++;
            }
            int freq = j - i + 1;
            st.add(freq);
            cnt++;
            i = j + 1;
        }
        return st.size() == cnt;
    }
} 
    }
}