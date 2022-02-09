// Time Complexity: O(n) where n is number of days
// Space Complexity: O(n)  where n is number of days
public class MinimumCostTicket
{
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        // since these are the only dates we are concerened for 
        int dp [] = new int[lastDay+1]; // since dp index are from 0
        
        // to check if the days are in travel days
        Set<Integer> travelDates = new HashSet<>();
        for(int day : days)
        {
            travelDates.add(day);
        }
    
        for(int i = 1; i <= lastDay; i++)
        {
            if(!travelDates.contains(i)) // since we do not need to travel use old 
            {
                dp[i] = dp[i-1];
                continue;
            }
            
            // 1 day ticket on day i, dp[i] = dp[i - 1] + cost[0]
            // need to check if i-n is valid or not math.max(day - x, 0)
            dp[i] = dp[i-1] + costs[0];
            //7 day ticket ending on day i, dp[i] = min(dp[i - 7]) + cost[1]
            dp[i] = Math.min(dp[Math.max(i-7, 0)] + costs[1], dp[i]);
            //30 day ticket ending on day i, dp[i] = min(dp[i - 30]) + cost[2]
            dp[i] = Math.min(dp[Math.max(i-30, 0)] + costs[2], dp[i]);
        }
        
        return dp[lastDay];
    }
}