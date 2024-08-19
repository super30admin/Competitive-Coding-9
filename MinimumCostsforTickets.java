// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int day : days) {
            set.add(day);
            max = Math.max(max, day);
        }
        int[] dp = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            if (set.contains(i))
                dp[i] = Math.min(dp[Math.max(i - 1, 0)] + costs[0],
                        Math.min(dp[Math.max(i - 7, 0)] + costs[1], dp[Math.max(i - 30, 0)] + costs[2]));
            else
                dp[i] = dp[i - 1];
        }

        return dp[max];

    }
}