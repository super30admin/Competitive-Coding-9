// Time Complexity : O(N) where N is the maximum number of day from days
// Space Complexity : O(N) for dp matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Since we have to calculate the minimum cost for all days exhaustively, using the dp array to store the best possible outcome for each day starting from day 1 to last day on the input.
 * Calculating the minimum cost of 1, 7 and 30 days for each day that we are travelling and storing in the dp array.
 * If we are not travelling on that day, then we can carryforward the cost from previous day.
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Set<Integer> set = new HashSet<>();
        // adding the details in set so the number of days we have to travel can have O(1) lookup
        for (int i = 0; i < n; i++) {
            set.add(days[i]);
        }

        int maxDays = days[n - 1];
        int[] dp = new int[maxDays + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // starting from day 1 so day 0 will be 0
        dp[0] = 0;

        for (int i = 1; i <= maxDays; i++) {
            if (set.contains(i)) {
                // do calculation
                int sevenDays = costs[1];
                int thirtyDays = costs[2];
                // bounds check for 7 and 30 days
                if (i >= 7) {
                    sevenDays += dp[i - 7];
                }
                if (i >= 30) {
                    thirtyDays += dp[i - 30];
                }
                dp[i] = Math.min(costs[0] + dp[i - 1], Math.min(sevenDays, thirtyDays));
            } else {
                // we are not visiting on this day so carryforwarding the cost from last day
                dp[i] = dp[i - 1];
            }
        }

        return dp[maxDays];
    }
}