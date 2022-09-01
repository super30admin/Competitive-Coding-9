import java.util.HashSet;

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        int max = days[days.length - 1];
        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
        }
        int dp[] = new int[max + 1];
        int decisions[] = new int[max + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (!daySet.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Math.min(dp[i - 1] + costs[0],
                    Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
        }

        return dp[dp.length - 1];

    }
}