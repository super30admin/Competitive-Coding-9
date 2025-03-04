//Time Complexity: O(n)
// Space Complexity: O(n)

public class MinCostTickets {
        public int mincostTickets(int[] days, int[] costs) {
            if (costs == null || days == null || days.length == 0 || costs.length == 0) {
                return 0;
            }

            int lastday = days[days.length - 1];
            int[] dp = new int[lastday + 1];
            boolean[] traveldays = new boolean[lastday + 1];

            for (int day : days) {
                traveldays[day] = true;
            }

            for (int i = 1; i <= lastday; i++) {
                if (!traveldays[i]) {
                    dp[i] = dp[i - 1];
                    continue;
                }

                dp[i] = costs[0] + dp[i - 1];
                dp[i] = Math.min(costs[1] + dp[Math.max(i - 7, 0)], dp[i]);
                dp[i] = Math.min(costs[2] + dp[Math.max(i - 30, 0)], dp[i]);
            }
            return dp[lastday];
        }
}
