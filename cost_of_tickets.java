
//TC - O(N)
//SC - O(1)
import java.util.*;

class Solution1 {
	public int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[days[days.length - 1] + 1];
		HashSet<Integer> set = new HashSet<>();
		for (int i : days) {
			set.add(i);
		}
		for (int i = 1; i < dp.length; i++) {
			if (set.contains(i)) {
				if (i >= 30) {
					dp[i] = Math.min(dp[i - 1] + costs[0], Math.min((dp[i - 7]) + costs[1], dp[i - 30] + costs[2]));
				} else if (i >= 7) {
					dp[i] = Math.min(dp[i - 1] + costs[0], Math.min((dp[i - 7]) + costs[1], costs[2]));
				} else {
					dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(costs[1], costs[2]));
				}
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[dp.length - 1];
	}
}