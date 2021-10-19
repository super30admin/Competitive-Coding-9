// Time Complexity: O(366) = O(1)
// Space Complexity: O(366) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        // Arrays.fill(dp, 365 * costs[0]);
        dp[n] = 0;
        for(int i = n - 1; i >= 0; --i) {
            int d7 = i, d30 = i;
            while(d7 < n && days[d7] < days[i] + 7) ++d7;
            while(d30 < n && days[d30] < days[i] + 30) ++d30;
            dp[i] = Math.min(costs[0] + dp[i + 1], Math.min(costs[1] + dp[d7], costs[2] + dp[d30]));
        }
        return dp[0];
    }
}