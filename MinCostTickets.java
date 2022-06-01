import java.util.HashSet;
import java.util.Set;

public class MinCostTickets {

    // Leetcode # 983
    // Dynamic programming approach
    // TC: O(n) n - last day in the days array
    // SC: O(n) since we are storing the elements into a dp array
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int day : days)
            set.add(day);

        int[] dp = new int[days[days.length - 1] + 1]; // size of whatever is the last day in days array

        for (int i = 1; i < dp.length; i++) {
            if (set.contains(i)) {
                int c1 = dp[i - 1] + costs[0]; // minimal cost up to the previous day + cost of buying 1-day pass
                int c7 = dp[Math.max(i - 7, 0)] + costs[1]; // Minimal cost up to the 7 days prior(if it exists else 0) (because this pass expired just 1 day back)
                                                                        // + cost of buying 7 days pass
                int c30 = dp[Math.max(i - 30, 0)] + costs[2]; // Minimal cost up to the 30 days prior(if it exists else 0) + cost of buying 30 days pass
                dp[i] = Math.min(c1, Math.min(c7, c30)); // get the minimum of all these possibilities
            } else {
                dp[i] = dp[i - 1]; // not travelling on this day, so copy the minimal cost from the previous travel day
            }
        }

        return dp[dp.length - 1];
    }
}
