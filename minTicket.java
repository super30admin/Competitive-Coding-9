// Time Complexity :constant
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        // we need a hashmap to check if the day for which we are calculating charges,
        // we have to travel that day or not
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            set.add(days[i]);
        }
        // calculating min cost for each day
        for (int i = 1; i < dp.length; i++) {
            // System.out.println("dp is"+dp[i-1]);
            if (!set.contains(i)) {// if we dont have to travel this day, dont add charges
                dp[i] = dp[i - 1];
            } else if (i < 7) {// take minimum of cost for 7 days and 1 day as we have days smaller than 7 and
                               // cannot take more than that
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(costs[1], costs[2]));
            } else if (i < 30) {
                // take minimum of cost for 30 ,7 and 1 day as we have days smaller than 30 and
                // cannot take more than that
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[i - 7] + costs[1], costs[2]));
            } else {// calculate min of all
                dp[i] = Math.min((dp[i - 1] + costs[0]), Math.min((dp[i - 7] + costs[1]), (dp[i - 30] + costs[2])));
            }

        }
        return dp[n];
    }
}