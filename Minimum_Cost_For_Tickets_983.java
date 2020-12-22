//Time Complexity : O(1) // 365 days
//Space Complexity : O(1) // 365 days
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.Arrays;

class Minimum_Cost_For_Tickets_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length - 1;
        int max = days[n];
        boolean[] isDay = new boolean[max+1];
        for(int day : days)
            isDay[day] = true;
        int[] dp = new int[max+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= max; i++){
            if(!isDay[i]){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = Math.min(dp[i], dp[i-1] + costs[0]);
            if(i - 7 >= 0)
                dp[i] = Math.min(dp[i], dp[i-7] + costs[1]);
            else dp[i] = Math.min(dp[i], costs[1]);
            if(i - 30 >= 0)
                dp[i] = Math.min(dp[i], dp[i-30] + costs[2]);
            else dp[i] = Math.min(dp[i], costs[2]);
        }
        return dp[max];
    }
    public static void main(String[] args)
    {
    	int[] arr = {1,2,4,5,6,7,8,20};
    	int[] costs = {7,2,15};
    	Minimum_Cost_For_Tickets_983 minCost = new Minimum_Cost_For_Tickets_983();
    	System.out.println(minCost.mincostTickets(arr, costs));
    }
}
