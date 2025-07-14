// TC: O(1)
// SC: O(1) Max 365 Days
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length - 1];
        int[] dp = new int[max + 1];
        HashSet<Integer> daySet = new HashSet<>();

        for (int day : days) {
            daySet.add(day);
        }

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            if (!daySet.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                int oneDayPass = dp[Math.max(0, i - 1)] + costs[0];
                int sevenDayPass = dp[Math.max(0, i - 7)] + costs[1];
                int thirtyDayPass = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
            }
        }

        return dp[dp.length - 1];
    }
}
