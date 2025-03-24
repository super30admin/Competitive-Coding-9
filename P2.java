/*
Time Complexity (TC): O(N), where N is the number of days in days, since each day is computed once and stored in memo.

Space Complexity (SC): O(N) due to the memoization array (memo[366]) and the dayset HashSet storing ticket days.

Code Explanation: The algorithm uses top-down dynamic programming (DP) with memoization to find the minimum cost of tickets for given travel days. 
It recursively checks if a day requires a ticket, then explores three options—1-day, 7-day, and 30-day passes—storing the minimum cost at each step.
The memo array caches results to avoid redundant calculations, optimizing performance.
 */

class Solution {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) dayset.add(d);
        return dp(1);
    }

    public int dp(int i) {
        if (i > 365)
            return 0;
        if (memo[i] != null)
            return memo[i];
        int ans;

        if (dayset.contains(i)) {
            ans = Math.min(dp(i+1) + costs[0],
            dp(i+7) + costs[1]);
            ans = Math.min(ans, dp(i+30) + costs[2]);
        } else {
            ans = dp(i+1);
        }
        memo[i] = ans;
        return ans;
    }
}
