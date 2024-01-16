// Time Complexity : O(max) -> max is the last day planned for travel
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Dynamic Programming
 */
class Solution {

    int dp[];
    public int mincostTickets(int[] days, int[] costs) {

        int max = days[days.length-1];
        int dayIndex = 0;
        this.dp = new int[max + 1];

        //TC: O(max)
        for(int i=1; i<=max; i++) {
            if(days[dayIndex] > i)
                dp[i] = dp[i-1];
            else {
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0, i-7)] + costs[1], dp[Math.max(0, i-30)] + costs[2]));
                dayIndex++;
            }
        }

        return dp[max];
    }
}