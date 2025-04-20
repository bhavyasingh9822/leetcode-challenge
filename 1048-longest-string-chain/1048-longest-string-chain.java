import java.util.*;

public class Solution {

    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return second == s2.length();
    }
        public int longestStrChain(String[] words) {

        int n = words.length;
        Arrays.sort(words, comp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (compare(words[i], words[prevIndex]) && dp[prevIndex] + 1 > dp[i]) {
                    dp[i] = dp[prevIndex] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }
}
 