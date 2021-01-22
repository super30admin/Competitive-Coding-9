// Time Complexity : O(N) , N is the last day, lies in between 0 and 365
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDay = days[days.length - 1];
        
        int[] dp = new int[lastDay + 1];
        
        boolean[] isTravelDay = new boolean[lastDay + 1];
        
        for(int day: days) {
            isTravelDay[day] = true;
        }
        
        for(int i = 1; i <= lastDay; i++) {
            
            if(!isTravelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            
            int oneDayPass = costs[0] + dp[i - 1];
            int sevenDayPass = costs[1] + dp[Math.max(i - 7, 0)];
            int thirtyDayPass = costs[2] + dp[Math.max(i - 30, 0)];
            
            dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        }
        return dp[lastDay];
    }
}