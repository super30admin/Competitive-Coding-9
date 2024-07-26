import java.util.HashSet;

public class MinCostTicket {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : days) {
            set.add(n);
        }
        int l = days[days.length - 1];
        int[] dp = new int[l + 1];
        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1] + costs[0],
                        Math.min(dp[Math.max(i - 7, 0)] + costs[1], dp[Math.max(i - 30, 0)] + costs[2]));
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        MinCostTicket m = new MinCostTicket();
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };
        int ans = m.mincostTickets(days, costs);
        System.out.println(ans);
    }
}
