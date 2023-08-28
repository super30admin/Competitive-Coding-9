package CompetitiveCoding9;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class MinimumCostTicketDP {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        int dayIndex = 0;
        for(int i=1; i<=lastDay; i++)
        {
            if(i < days[dayIndex])
            {
                dp[i] = dp[i-1];
                continue;
            }
            dayIndex++;
            dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[Math.max(i-7,0)]+costs[1],
                    dp[Math.max(i-30,0)]+costs[2]));
        }

        return dp[lastDay];
    }
}
