// Time Complexity : O(n) - where n is the days array length
// Space Complexity : O(m) - where m is the maximum number of days in the travel
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

// Using DP approach to find the cost of tickets at each day and compare with the previous 2 days, 7 days and 30 days back

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length ==0 || days == null) return 0;
        int n = days.length;
        int[] dp = new int[days[n-1]+1];
        int t=0;
        for(int i=1;i<=days[n-1];i++){
            if(i == days[t]){
                dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[Math.max(i-7,0)]+costs[1],dp[Math.max(i-30,0)]+costs[2]));
                t++;
            }
            else
                dp[i] = dp[i-1];
        }
        return dp[days[n-1]];
    }
}
