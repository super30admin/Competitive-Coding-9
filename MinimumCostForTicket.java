//Time Complexity O(N)
//Space Complexity O(N)
//Leetcode tested

import java.util.HashSet;

public class MinimumCostForTicket {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
        }
        int[] dp = new int[366];
        dp[0] = 0;
        for (int i = 1; i < 366; i++) {
            if(!daySet.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[Math.max(0,i-7)]+costs[1],dp[Math.max(0,i-30)]+costs[2]));
        }
        return dp[365];
    }
}
