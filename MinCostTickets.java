// TC: O(n)
// SC: O(n)

// Approach: At any point; you will need the min cost at indexes where
// daily, weekly, monthly pass ends and add the min cost from there onwards.
// Use bottom up dp to calculate cost at last index and so on.

class MinCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        // for 1 day, take pass with min price
        dp[dp.length - 1] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for (int i = dp.length - 2; i >= 0; i--) {
            // day pass
            int val1 = costs[0] + dp[i + 1];
            // week pass
            int nextIndex = i + 1;
            while (nextIndex < days.length && days[nextIndex] - days[i] < 7) {
                nextIndex++;
            }
            int val2 = costs[1];
            if (nextIndex < days.length) {
                val2 += dp[nextIndex];
            }

            // month pass
            while (nextIndex < days.length && days[nextIndex] - days[i] < 30) {
                nextIndex++;
            }
            int val3 = costs[2];
            if (nextIndex < days.length) {
                val3 += dp[nextIndex];
            }

            dp[i] = Math.min(val1, Math.min(val2, val3));
        }

        return dp[0];
    }
}