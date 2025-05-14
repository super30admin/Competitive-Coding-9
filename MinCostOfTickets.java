import java.util.HashSet;

public class MinCostOfTickets {
    public int minCostTickets(int[] days, int[] costs) {
        int n = days.length;
        int max = days[n - 1];

        HashSet<Integer> set = new HashSet<>();

        for (int day : days) {
            set.add(day);
        }

        int[] dp = new int[max + 1];

        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1]; // Not a travel day
            } else {
                int cost1 = dp[i - 1] + costs[0];
                int cost7 = dp[Math.max(0, i - 7)] + costs[1];
                int cost30 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }
        return dp[dp.length - 1];
    }

}

//TC: O(k) where k is the maximum no: of days given in the array
//SC: O(k)
