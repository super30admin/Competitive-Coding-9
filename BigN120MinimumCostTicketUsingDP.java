//Time complexity is O(nlogn)
//Space complexity is O(1)
//This solution is submitted on leetcode

import java.util.HashSet;

public class BigN120MinimumCostTicketUsingDP {
	class Solution {
		public int mincostTickets(int[] days, int[] costs) {
			// edge case
			if (days == null || costs == null)
				return 0;
			if (days.length == 0 || costs.length == 0)
				return 0;
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < days.length; i++) {
				set.add(days[i]);
			}
			int[] dp = new int[366];
			dp[0] = 0;
			for (int i = 1; i < 366; i++) {
				if (!set.contains(i)) {
					dp[i] = dp[i - 1];
					continue;
				}
				int twoTicket = dp[i - 1] + costs[0];
				int sevenTicket = dp[Math.max(0, i - 7)] + costs[1];
				int thirdTicket = dp[Math.max(0, i - 30)] + costs[2];
				int min1 = Math.min(twoTicket, sevenTicket);
				dp[i] = Math.min(min1, thirdTicket);
			}
			return dp[365];
		}
	}
}