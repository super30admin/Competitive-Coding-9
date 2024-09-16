//https://leetcode.com/problems/minimum-cost-for-tickets/
/*
Time: O(totalDays)
Space: O(totalDays)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {

        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        Set<Integer> set = new HashSet<>();

        // to account only for the given days. Other days are not important
        for (int day : days)
            set.add(day);

        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            int c1 = dp[i - 1];
            int c7 = (i - 7) > 0 ? dp[i - 7] : 0;
            int c30 = (i - 30) > 0 ? dp[i - 30] : 0;

            dp[i] = Math.min(c1 + costs[0], Math.min(c7 + costs[1], c30 + costs[2]));

        }

        return dp[dp.length - 1];

    }

}
