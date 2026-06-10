// Time Complexity : O(n²) because for each index we may scan ahead to find the next uncovered travel day
// Space Complexity : O(n) for memoization and recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use DFS with memoization where helper(i) represents the minimum cost to cover travel days starting from index i.
// At each travel day, we try buying a 1-day, 7-day, or 30-day pass and recursively compute the remaining cost.
// Memoization ensures each starting index is solved only once.

class Solution {
    int[] days;
    int[] costs;
    int[] memo;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        this.memo = new int[days.length];

        return helper(0);
    }

    private int helper(int i) {

        // all travel days covered
        if(i >= days.length) return 0;

        // previously computed
        if(memo[i] != 0) return memo[i];

        int one = costs[0] + helper(nextIndex(i, days[i] + 1));
        int seven = costs[1] + helper(nextIndex(i, days[i] + 7));
        int thirty = costs[2] + helper(nextIndex(i, days[i] + 30));

        memo[i] = Math.min(one, Math.min(seven, thirty));
        return memo[i];
    }

    // find first day not covered by current pass
    private int nextIndex(int i, int validUntil) {
        while(i < days.length && days[i] < validUntil) {
            i++;
        }
        return i;
    }
}