// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach
// we use dp to solve this
// we put the all the days in the has set
// then we create a dp array with length as the max day
// Then we iterate through the dp array and calculate the minimum

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        int max = days[days.length - 1];
        int[] dp = new int[max + 1];
        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];

            } else {
                dp[i] = Math.min(
                        dp[i - 1] + costs[0],
                        Math.min(
                                dp[Math.max(i - 7, 0)] + costs[1],
                                dp[Math.max(i - 30, 0)] + costs[2]));
            }
        }
        return dp[max];
    }
}