/*
Minimum Cost For Tickets
approach: at each travelling day, we have find which is costing us the minimum, is it 1 day pass or 7 day pass or 30 day pass
time: O(day1 to maximum day given in days array)
space: O(day1 to maximum day given in days array)
 */
public class Problem1 {
    public int mincostTickets(int[] days, int[] costs) {

        int max = days[days.length-1];

        // we need this to check what days we're travelling
        int[] travelDays = new int[max+1];
        for(int i:days) {
            travelDays[i] = -1;
        }
        int dp[] = new int[max+1];
        dp[0] = 0;

        for(int i=1;i<dp.length;i++) {
            int prevCost = dp[i-1];
            if(travelDays[i]==0) {
                dp[i] = prevCost; continue;
            }

            // we have to chose (min cost+max days) for all costs
            dp[i] = costs[0] + prevCost;
            dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]);
            dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]);
        }

        return dp[dp.length-1];
    }
}
