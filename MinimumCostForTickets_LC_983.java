/*
Approach :
    Build daySet for quick travel day checks.
    Fill dp[] where dp[i] = cheapest way to cover up to day i.
    If not traveling today → just copy yesterday’s cost.
    If traveling → take min of (1-day + dp[i-1]), (7-day + dp[i-7]), (30-day + dp[i-30]).
    Handle days before day 1 safely with Math.max(0, …).
Time complexity - O(N) + Max no of days
space complexity - O(N) + Max no of days

Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
import java.util.HashSet;
public class MinimumCostForTickets_LC_983 {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        int max= days[days.length-1];
        int [] dp = new int[max + 1];
        for(int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
        }
        dp[0] = 0;
        for(int i = 1; i< dp.length; i++) {
            if(!daySet.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] =  Math.min(
                    dp[i-1] + costs[0], //1 day pass
                    Math.min(dp[Math.max(0, i-7)] + costs[1] , //7 days pass
                            dp[Math.max(0, i-30)] + costs[2])); //30 days pass

        }
        return dp[dp.length-1];

    }
}