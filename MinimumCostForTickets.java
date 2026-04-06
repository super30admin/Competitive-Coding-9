// Time Complexity : O(lastday)
// Space Complexity : O(lastday)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We take a set for faster search of travel days and use a helper method to recursively check the minimum value
between 1-day,7-day and 30-day cost comparisons and store it to answer variable and thereby in dp array which
we want to memorize and use it for later results.We start this process from i=1 and want to recurse only if
that day falls in our given travel day set.At any point of time,if we cross 365 days, we return.
 */
class Solution {
    Integer[] memo;
    Set<Integer> set;
    int ans;
    public int mincostTickets(int[] days, int[] costs) {
        this.memo = new Integer[366];
        this.set = new HashSet<>();
        for(int d : days) {
            set.add(d);
        }
        return helper(1, costs);
    }

    private int helper(int i , int[] costs) {
        if(i > 365)
            return 0;

        if(memo[i] != null)
            return memo[i];


        if(set.contains(i)) {
            ans = Math.min((helper(i + 1 , costs) + costs[0]) , helper(i + 7, costs) + costs[1]);
            ans = Math.min(ans, helper(i + 30, costs) + costs[2]);
        }
        else {
            helper(i + 1, costs);
        }
        memo[i] = ans;
        return ans;
    }
}
