// Time Complexity : O(N), N is no.of travel days
// Space Complexity : O(N)  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

//https://leetcode.com/problems/minimum-cost-for-tickets/

public class Solution {
    public int MincostTickets(int[] days, int[] costs) {

        int maxDay = days[days.Length -1];

        HashSet<int> travelDays = new HashSet<int>(days);

        int[] dp = new int[maxDay+1];
        dp[0] = 0; //no cost on day 0

        for(int day =1; day<=maxDay; day++){
            if(!travelDays.Contains(day)){ //not a travel day
                dp[day] = dp[day-1];
            }
            else{// travel day
                dp[day] = Math.Min(
                    dp[Math.Max(0,day-1)] + costs[0],
                    Math.Min(
                        dp[Math.Max(0,day-7)] + costs[1], 
                        dp[Math.Max(0,day-30)] + costs[2]
                    )
                );
            }
        }
        return dp[maxDay];
        
    }
}