
// Time Complexity :O(N ) for dp where N = Number of Unique Days
// Space Complexity : O(N )
// Did this code successfully run on Leetcode : Yes Both Approaches Worked
//
/*
Algorithm Steps

dp[i] means up to i-th day the minimum cost of the tickets. The size of the dp array depends on the last travel day, so we don't need an array length to be 365.

We do need a boolean array to mark the travel days, the reason is if it is not a travel day we don't need a ticket. However, if it is a travel day, we consider three scenarios (with three types of tickects):

If a 1-day ticket on day i, dp[i] = dp[i - 1] + cost[0]
If a 7-day ticket ending on day i, dp[i] = min(dp[i - 7], dp[i - 6] ... dp[i - 1]) + cost[1]
If a 30-day ticket ending on day i, dp[i] = min(dp[i - 30], dp[i - 29] ... dp[i - 1]) + cost[2]

But since the value of dp array is increasing, therefore:
For a 7-day ticket ending on day i, dp[i] = dp[i - 7] + cost[1]
For a 30-day ticket ending on day i, dp[i] = dp[i - 30] + cost[2]
 */
public class MinTicketCost {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int dp[] = new int[lastDay + 1];

        boolean visited[] = new boolean[lastDay + 1];

        for(int day :days){
            visited[day] = true;
        }
        for(int i = 1; i < lastDay + 1; i++){
            if(!visited[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            int one = costs[0] + dp[i - 1];
            int seven = costs[1] + dp[Math.max(i - 7,0)];
            int thirty = costs[2] + dp[Math.max(i - 30,0)];
            dp[i] = Math.min(one,Math.min(seven,thirty));
        }
        return dp[lastDay];
    }

    public static void main(String args[]){
        int days[] = {1,4,6,7,8,20};
        int costs[] = {2,7,15};
        MinTicketCost cost = new MinTicketCost();

        System.out.println("Minimum Ticket cost is:" + cost.mincostTickets(days,costs));
    }
}