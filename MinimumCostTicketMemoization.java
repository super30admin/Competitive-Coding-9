package CompetitiveCoding9;
// Time Complexity : O(n);
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class MinimumCostTicketMemoization {
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        int cost =  helper(days,costs,0);
        return cost;
    }

    public int helper(int[] days, int[] costs, int dayIndex)
    {
        //base case
        if(dayIndex >= days.length) return 0;

        // logic
        if(dp[dayIndex] != 0) return dp[dayIndex];

        int oneday = helper(days,costs,dayIndex+1)+costs[0];
        int i;
        for(i=dayIndex; i<days.length; i++)
        {
            int daysCovered = days[dayIndex]+7;
            if(days[i] >= daysCovered)
            {
                break;
            }
        }
        int sevenday = helper(days,costs,i)+costs[1];

        for(i=dayIndex; i<days.length; i++)
        {
            int daysCovered = days[dayIndex]+30;
            if(days[i] >= daysCovered)
                break;
        }

        int thirtydays = helper(days,costs,i)+costs[2];
        dp[dayIndex] = Math.min(oneday,Math.min(sevenday,thirtydays));
        System.out.println(dayIndex +" "+dp[dayIndex]);
        return dp[dayIndex];

    }
}
