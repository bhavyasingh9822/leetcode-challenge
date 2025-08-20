class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && citations[j - 1] < citations[j]) {
                int temp = citations[j - 1];
                citations[j - 1] = citations[j];
                citations[j] = temp;
                j--;
            }
        }
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }
        return h;
    }
}