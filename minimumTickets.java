// Time Complexity: O(D), where D is the last day of travel. This is because we iterate over each day from 1 to lastDay and perform constant time operations for each day.


// Space Complexity: O(D), where D is the last day of travel. This space is used for the dp array which stores the minimum cost for each day up to the last day of travel.
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Step 1: Use a HashSet to quickly check if a day is a travel day
        HashSet<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        // Step 2: Find the last day of travel to create a dp array
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1]; // dp[i] will hold the minimum cost to cover up to day i

        // Step 3: Initialize dp[0] to 0 (no cost before any travel starts)
        dp[0] = 0;

        // Step 4: Iterate over each day from 1 to lastDay
        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                // If it's not a travel day, carry forward the cost from the previous day
                dp[i] = dp[i - 1];
            } else {
                // If it's a travel day, calculate the minimum cost using the three ticket options

                // Option 1: 1-day pass, add its cost to the previous day's total
                int oneDayPassCost = dp[i - 1] + costs[0];

                // Option 2: 7-day pass, consider the cost 7 days ago (or start of travel)
                int sevenDayPassCost = dp[Math.max(0, i - 7)] + costs[1];

                // Option 3: 30-day pass, consider the cost 30 days ago (or start of travel)
                int thirtyDayPassCost = dp[Math.max(0, i - 30)] + costs[2];

                // Choose the minimum of the three options
                dp[i] = Math.min(oneDayPassCost, Math.min(sevenDayPassCost, thirtyDayPassCost));
            }
        }

        // Step 5: The answer is the cost to cover all days up to the last travel day
        return dp[lastDay];
    }
}
