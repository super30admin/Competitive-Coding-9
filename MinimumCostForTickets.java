// Time Complexity : O(n), n - last day in days array
// Space Complexity : O(n), dp array
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use a DP array which stores the minimum cost to cover up to day i.
// For each travel day, choose the minimum among buying 1-day, 7-day or 30-day pass.
// If the day is not a travel day, just carry over the previous day’s cost.

import java.util.*;
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet=new HashSet<>();
        int n=days[days.length-1];
        for(int day:days){
            daySet.add(day);
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            if(!daySet.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }
            dp[i]=Math.min(dp[i-1]+costs[0],
                  Math.min(dp[Math.max(0,i-7)]+costs[1],dp[Math.max(0,i-30)]+costs[2]));
        }
        return dp[dp.length-1];
    }
}


// Time Complexity : O(n),n- maximum day in the days array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Approach:
// Mark all travel days in a boolean array up to the last travel day.
// Use a dp array to calculate the minimum cost for each day up to the last travel day.
// For each travel day, choose the minimum among 1-day, 7-day, or 30-day passes.

class Solution2 {
    public int mincostTickets(int[] days, int[] costs) {
        int max=days[days.length-1];
        boolean[] travelDay=new boolean[max+1];
        for(int day:days){
            travelDay[day]=true;
        }
        int[] dp=new int[max+1];
        dp[0]=0;
        for(int i=1;i<=max;i++){
            if(!travelDay[i]){
                dp[i]=dp[i-1];
                continue;
            }
            dp[i]=dp[i-1]+costs[0];
            dp[i]=Math.min(dp[Math.max(0,i-7)]+costs[1],dp[i]);
            dp[i]=Math.min(dp[Math.max(0,i-30)]+costs[2],dp[i]);
        }
        return dp[max];
    }
}