// Time Complexity : O(n), n -> Number of unique days in travel plan
// Space Complexity : O((n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class MinimumCostForTickets {
	Integer[] dp;
	int[] duration;

	public int mincostTickets(int[] days, int[] costs) {
		if (days == null || days.length == 0 || costs == null || costs.length == 0) {
			return 0;
		}

		dp = new Integer[days.length];
		duration = new int[] { 1, 7, 30 };

		return helper(0, days, costs);
	}

	public int helper(int day, int[] days, int[] costs) {
		if (day >= days.length) {
			return 0;
		}

		if (dp[day] != null) {
			return dp[day];
		}

		int ans = Integer.MAX_VALUE;

		int i = day;

		for (int j = 0; j < 3; j++) {
			while (i < days.length && days[i] < days[day] + duration[j]) {
				i++;
			}
			ans = Math.min(ans, helper(i, days, costs) + costs[j]);
		}

		dp[day] = ans;
		return ans;
	}

	public static void main(String[] args) {
		MinimumCostForTickets obj = new MinimumCostForTickets();
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };

		System.out.println("Minimum cost: " + obj.mincostTickets(days, costs));
	}
}
