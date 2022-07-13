// Time Complexity : O(N)
// Space Complexity : O(N) + O(N), set and aray
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class MinimumCostForTickets {
    private int result;
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int day : days) {
            set.add(day);
        }
        int len = days.length;
        int max = days[len -1];
        int dp[] = new int[max + 1];
        dp[0] = 0;
        for(int i=1; i< dp.length; i++) {
            if(!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            } else {
                dp[i] = Math.min(
                        dp[i-1] + costs[0], // 1-day pass
                        Math.min(
                                dp[Math.max(0, i-7)] + costs[1], //7-day pass
                                dp[Math.max(0, i-30)] + costs[2] // 30-day pass
                        )
                );
            }
        }

        return dp[dp.length - 1];
    }
}
