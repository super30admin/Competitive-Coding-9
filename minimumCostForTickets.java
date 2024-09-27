//Time complexity O(n)
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];//only having the dp array till the last day we are travelling
        
        boolean[] vis = new boolean[lastDay+1];
        for(int i = 0; i < days.length; i ++){//visited array to see if we are travelling on this day
            
            vis[days[i]] = true;
        }
        
        for(int i = 1; i < dp.length; i ++){
            
            if(vis[i] == false){//if we are not travelling on this day, then add the cost from previous day
                
                dp[i] = dp[i-1];
                continue;
            }
            
            int cost1 = costs[0] + dp[i-1]; //calculate cost of 1 day pass
              int cost2 = costs[1] + dp[Math.max(i-7,0)];//calculate cost of 7 day pass
            int cost3 = costs[2] + dp[Math.max(i-30,0)];//calculate cost of 30 day pass
            
           dp[i] = Math.min(cost1,Math.min(cost2,cost3));
        }
        
        return dp[lastDay];
        
    }
}