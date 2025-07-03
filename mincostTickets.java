public class MincostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for (int day : days) {
            daySet.add(day);
            max = Math.max(max, day);
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;

        for (int i = 1; i <= max; i++) {
            if (!daySet.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(
                    dp[i - 1] + costs[0],
                    Math.min(
                        dp[Math.max(0, i - 7)] + costs[1],
                        dp[Math.max(0, i - 30)] + costs[2]
                    )
                );
            }
        }

        return dp[max];
    }
}