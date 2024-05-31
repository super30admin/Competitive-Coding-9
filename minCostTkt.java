import java.util.*;

//Using 1D DP

class Solution {
    // Tc: O(n+L) Sc: O(n+L)
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            set.add(days[i]);
        }

        int dpLen = days[days.length - 1];

        int dp[] = new int[dpLen + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = Math.min(dp[i - 1] + costs[0],
                    Math.min(costs[1] + dp[Math.max(0, i - 7)],
                            costs[2] + dp[Math.max(0, i - 30)]));
        }
        return dp[dp.length - 1];
    }
}