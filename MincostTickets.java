// Problem 983. Minimum Cost For Tickets
// Time Complexity : O(D)
// Space Complexity : O(D)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
            max = Math.max(max, days[i]);
        }
        int[] dp = new int[max + 1];
        dp[0] = 0; // No cost on day 0
        for (int i = 1; i < dp.length; i++) {
            // If it is not a travel day, the cost remains the same as the previous day
            if (!daySet.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }
            // Calculate the minimum cost by taking either: A 1-day pass (cost[0]), A 7-day pass (cost[1]), A 30-day pass (cost[2])
            dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
        }
        return dp[dp.length - 1];
    }
}
