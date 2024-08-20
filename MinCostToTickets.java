// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinCostToTickets {
    // Using Tabulation
    HashSet<Integer> set;

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        this.set = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            set.add(days[i]);
        }
        int lastDay = days[n - 1];
        int[] dp = new int[lastDay + 1];
        dp[0] = 0;
        // fill the dp array
        for (int i = 1; i <= lastDay; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            int oneDayPass = costs[0] + dp[Math.max((i - 1), 0)];
            int sevenDayPass = costs[1] + dp[Math.max((i - 7), 0)];
            int thirtyDayPass = costs[2] + dp[Math.max((i - 30), 0)];
            dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        }
        return dp[lastDay];
    }
}