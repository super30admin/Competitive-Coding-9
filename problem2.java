// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
Appraoch 
we are using DP to solve this one and memorisation to optimise it

at any day we have three options of buying the ticket 1,7 or 30 days, 
we explore all the options
the inner while loop to move the pointer to find the day to travel after our curent pass ends
*/

class Solution {
    private Integer[] memo;

    public int mincostTickets(int[] days, int[] costs) {
        this.memo = new Integer[days.length];
        return dfs(days, costs, 0);
    }

    private int dfs(int[] days, int[] costs, int i) {
        if (i == days.length)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int res = Integer.MAX_VALUE;
        int j = i;
        int[] durations = { 1, 7, 30 };
        for (int k = 0; k < 3; k++) {
            int cost = costs[k];
            int duration = durations[k];

            while (j < days.length && days[j] < days[i] + duration) {
                j++;
            }
            res = Math.min(res, cost + dfs(days, costs, j));
            j = i;
        }
        memo[i] = res;
        return res;
    }
}