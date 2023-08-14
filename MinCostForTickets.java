public class MinCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int largest = days[days.length-1];
        int[] dp = new int[largest+1];
        dp[0] = 0;

        Set<Integer> set = new HashSet<>();
        for (int day : days) { // O(n)
            set.add(day);
        }
        for (int day = 1; day < dp.length; day++) { // O(n)

            if (set.contains(day)) { // O(1)
                dp[day] = Math.min(dp[day-1] + costs[0], Math.min(dp[Math.max(0, day-7)] + costs[1], dp[Math.max(0, day-30)] + costs[2]));
            } else {
                dp[day] = dp[day-1];
            }
        }
        return dp[dp.length-1];
    }
}

// Time Complexity - O(max(n,l)) n = length of days array, l = largest element of days array
// Space Complexity - O(n) n = length of days array