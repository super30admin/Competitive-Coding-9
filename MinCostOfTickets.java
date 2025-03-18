/*
 * TC: O(lastDay)
 * SC: O(lastDay)
 */
import java.util.HashSet;
import java.util.Set;

public class MinCostOfTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        // set to check if the day is present in days in O(1)
        Set<Integer> daySet = new HashSet<>();
        // dp array is an array of all days uptil the lastDay
        int[] dp = new int[lastDay + 1];
        for(int d: days) daySet.add(d);
        for(int d = 1; d <= lastDay; d++) {
            // if the day is present in days,
            // f(d) = min(f(d-1), f(d-7), f(d-30)) (calculate min cost pass)
            // else f(d) = f(d-1) (just copy previous day's value)
            if(daySet.contains(d)) {
                dp[d] = Math.min(dp[d - 1] + costs[0],
                        Math.min(dp[Math.max(0, d - 7)] + costs[1],
                                dp[Math.max(0, d - 30)] + costs[2]));
            } else {
                dp[d] = dp[d - 1];
            }
        }
        return dp[lastDay];
    }
}
