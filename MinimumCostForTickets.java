// Time Complexity :O(n) since we are iterating dp array
// Space Complexity : O(n) since we are using extra space in terms of dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    int minDollars = Integer.MAX_VALUE;
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        HashSet<Integer> set = new HashSet<>();
        for(int i : days){
            set.add(i);
        }
        for(int i = 1; i < 366; i++)
        {
            if(set.contains(i))
            {
                int dayPass = (i-1 > 0 ? dp[i-1]: dp[0])+ costs[0];
                int weekPass = (i-7 > 0 ? dp[i-7] : dp[0])+ costs[1];
                int monthPass = (i-30 > 0 ? dp[i-30] :dp[0])+ costs[2];
                dp[i] = Math.min(dayPass, Math.min(weekPass, monthPass));
                minDollars = dp[i];
            }
            else
            {
                dp[i] = dp[i-1];
            }
        }
        return minDollars;
    }
}