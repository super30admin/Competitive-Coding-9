/**
 * BF
 * try all combinations
 * at every level, we have 3 choices, day1 pass, 7day pass, and 30 day pass
 * so, at last store minimum
 * we have repepated subproblems here!
 * TC: 3^n
 * SC: O(n) - height of the tree
 */

/*
 * Optimized Approach
 * Take dp array, with the size = max value of the days array!
 * traverse through the days array, and add minof three(previos cost+day1,
 * prvious cost + day15 , prevcost+day30)
 * when we dont have days in dp that belongs to the Days array, we just copy the
 * last values
 * tc: O(Max D) = shouldnot be more tha 365 - O(1)
 * sc: same as TC
 */

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // base case
        if (days == null)
            return 0;

        int n = days.length;
        int[] dp = new int[days[n - 1] + 1];
        int finalcost = Integer.MAX_VALUE;
        // 1st - day 1
        // 2nd - day 7
        // 3rd - 30 days
        int j = 0; // traverse on my days array!

        for (int i = 1; i < dp.length; i++) {
            if (i == days[j]) {
                int tempCost = Integer.MAX_VALUE;

                // day1 calculation
                int day1 = dp[i - 1] + costs[0];

                // calculuate i-7, i-30
                int day7 = Integer.MAX_VALUE;
                if (i < 7) {
                    day7 = costs[1];
                } else {
                    day7 = Math.min(day7, costs[1] + dp[i - 7]);
                }

                int day30 = Integer.MAX_VALUE;
                if (i < 30) {
                    day30 = costs[2];
                } else {
                    day30 = Math.min(day30, costs[2] + dp[i - 30]);
                }
                // increase j
                j++;
                tempCost = Math.min(day1, day7);
                tempCost = Math.min(tempCost, day30);
                dp[i] = tempCost;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}