/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n*30)
    n - length of days array
* 
* Space Complexity: O(n)
* 
*/

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] passDays = new int[] { 1, 7, 30 };

        int[] dp = new int[days.length];

        return helper(days, costs, passDays, days.length - 1, dp);
    }

    private int helper(int[] days, int[] costs, int[] passDays, int index, int[] dp) {
        int minValue = Integer.MAX_VALUE;

        if (index < 0) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        for (int i = 0; i < passDays.length; i++) {
            int dayIndex = index;

            int requiredDay = days[index] - passDays[i];

            while (dayIndex >= 0 && days[dayIndex] > requiredDay) {
                dayIndex--;
            }

            minValue = Math.min(minValue, costs[i] + helper(days, costs, passDays, dayIndex, dp));

        }
        dp[index] = minValue;

        return dp[index];
    }
}