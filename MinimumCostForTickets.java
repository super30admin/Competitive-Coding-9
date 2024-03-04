// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: DP Tabulation

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        
        for (int idx = n - 1; idx >= 0; idx--) {
            // 1 day pass
            int option1 = costs[0] + dp[idx + 1]; 
            
            // 7 days
            int i;
            for (i=idx;i < n && days[i] < days[idx] + 7;i++); 
            int option2 = costs[1] + dp[i];
            
            //30 days
            for (i=idx; i < n && days[i] < days[idx] + 30;i++); 
            int option3 = costs[2] + dp[i]; 
            
            dp[idx] = Math.min(option1, Math.min(option2, option3)); 
        }
        
        return dp[0];
    }
}
