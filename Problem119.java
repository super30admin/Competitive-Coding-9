//TC: O(d)
//SC: O(d)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Create a set for fast lookup of travel days
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        // DP array to store minimum cost up to each day
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];

        for (int i = 1; i <= maxDay; i++) {
            if (!travelDays.contains(i)) {
                // If it's not a travel day, cost remains the same as the previous day
                dp[i] = dp[i - 1];
            } else {
                // Calculate the cost for 1-day, 7-day, and 30-day passes
                int cost1 = dp[i - 1] + costs[0];
                int cost7 = dp[Math.max(0, i - 7)] + costs[1];
                int cost30 = dp[Math.max(0, i - 30)] + costs[2];
                // Take the minimum of the three costs
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }

        return dp[maxDay]; // The minimum cost to cover all travel days
    }
}
