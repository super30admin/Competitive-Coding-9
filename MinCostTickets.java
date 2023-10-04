// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Using Bottom up appoach Dp
class Solution { 
   
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[395];

        for(int j =0; j<days.length; j++){
            int d = days[j];
            dp[d+29] = 1;
        }

        for(int i = 30 ; i<dp.length ; ++i){
            if(dp[i] == 0) {
                dp[i] = dp[i-1];
            } 
            else{
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[i-7] + costs[1], dp[i-30] + costs[2]) );
            }
        }

        return dp[394];
}
}