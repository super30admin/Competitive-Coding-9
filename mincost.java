// Time Complexity : O(n) -> days
// Space Complexity : O(n) days hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // HashSet of days
        int[] dp = new int[days.length + 1];
        dp[0] = 0;
        int dayPointer;
        for(int i = 1; i <= days.length; i++){
            int currDay = days[i-1];
            // 1 days pass
            dp[i] = dp[i-1] + costs[0];
            // 7 day pass
            dayPointer = i -1;
            while( dayPointer >= 0  && currDay - days[dayPointer]  < 7){
                dayPointer--;
            }
            dp[i] = Math.min(dp[i], dp[dayPointer + 1] + costs[1]);
            // 30 day pass
            while( dayPointer >= 0  && currDay - days[dayPointer]  < 30){
                dayPointer--;
            }
            dp[i] = Math.min(dp[i], dp[dayPointer + 1] + costs[2]);
        }
        return dp[days.length];
    }
}