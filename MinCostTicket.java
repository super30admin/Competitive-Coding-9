// Time Complexity : O(365)
// Space Complexity : O(365)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MinCostTicket {
    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int n = days.length;
            if(n == 0)
                return 0;

            int maxDays = days[n - 1];
            int[] dp = new int[maxDays + 1];
            int idx = 0;

            for(int i = 0; i <= maxDays; i++){
                if(i == days[idx]){
                    dp[i] = dp[i - 1] + costs[0];
                    if(i >= 7){
                        dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
                    }else{
                        dp[i] = Math.min(dp[i], costs[1]);
                    }
                    if(i >= 30){
                        dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
                    }else{
                        dp[i] = Math.min(dp[i], costs[2]);
                    }
                    idx++;
                }
                else if(i > 0){
                    dp[i] = dp[i - 1];
                }

            }
            return dp[maxDays];
        }
    }
}
