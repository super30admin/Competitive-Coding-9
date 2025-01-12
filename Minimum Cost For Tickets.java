// Approach :
// Time : O(1)
// Space : O(n) ~ size of days array
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        int max = days[days.length - 1]; // days of the year are already sorted then find max;

        int[] dp = new int[max + 1];
        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                // not a travel day - just take the previous day cost
                dp[i] = dp[i - 1];
            } else {
                // 3 choices - 1 -day pass , 7 day pass & 30 day pass
                int temp = Math.min(
                        dp[Math.max(i - 7, 0)] + costs[1], // 7-day
                        dp[Math.max(i - 30, 0)] + costs[2]); // 30 day
                dp[i] = Math.min(dp[i - 1] + costs[0], temp); // 1-day
            }
        }
        return dp[dp.length - 1];
    }
}