// TC: O(1)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int[] costs;
    Integer[] memo;
    Set<Integer> daySet;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        daySet = new HashSet<>();
        for (int d : days) {
            daySet.add(d);
        }
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        if (daySet.contains(i)) {
            ans = Math.min(dp(i + 1) + costs[0], dp(i + 7) + costs[1]);
            ans = Math.min(ans, dp(i + 30) + costs[2]);
        } else {
            ans = dp(i + 1);
        }
        memo[i] = ans;
        return ans;
    }
}
