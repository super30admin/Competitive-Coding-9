// Time Complexity : O(N) N is the number of days in the days array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Our mincostTickets method calculates the minimum cost required to purchase tickets for a travel plan given the days array representing travel days and the costs array containing the cost of tickets for 1-day, 7-day, and 30-day durations.
// It uses dynamic programming to find the optimal solution. The dp array stores the minimum cost to travel up to each day. It iterates through the days array, considering different durations (1-day, 7-day, or 30-day) and updates the dp array accordingly.

import java.util.Arrays;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] durations = { 1, 7, 30 };
        for (int i = 1; i <= days.length; i++) {
            for (int k = 0; k < 3; k++) {
                int next = i;
                // while(next >= 1 && days[next - 1] > days[i - 1] - durations[k]){
                while (next >= 1 && days[i - 1] < days[next - 1] + durations[k]) {
                    next--;
                }
                dp[i] = Math.min(dp[i], dp[next] + costs[k]);
            }
        }
        return dp[days.length];
    }

    public static void main(String[] args) {
        MinimumCostForTickets obj = new MinimumCostForTickets();
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };
        int minCost = obj.mincostTickets(days, costs);
        System.out.println("Minimum cost for tickets: " + minCost);
    }
}
