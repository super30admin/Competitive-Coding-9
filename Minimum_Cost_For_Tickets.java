import java.util.Arrays;

public class Minimum_Cost_For_Tickets {
    public int mincostTickets(int[] days, int[] costs) {
        //TC: O(n)
        //SC: O(1)
        boolean[] travelDays = new boolean[366];
        for (int day : days) {
            travelDays[day] = true;
        }

        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= 365; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }
        return dp[365];
    }
}
