import java.util.HashSet;
import java.util.Set;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int largest = days[days.length-1];
        int[] dp = new int[largest+1];
        dp[0] = 0;

        Set<Integer> set = new HashSet<>();
        // easy checking for days present
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

        for (int i=0;i<dp.length;i++){
            System.out.println(dp[i]);
        }

        return dp[dp.length-1];
    }
}