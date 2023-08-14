// Time Complexity : O(365)
// Space Complexity : O(365)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Take a dp array of 366 size. Iterate on each index of dp and check if its
 * matching to the day in the days array. if not, just copy the previous value
 * to the current index of dp. Else, find the i-1 + cost[0], i-7 + cost[1], i-30
 * + cost[30] and take the min of them to update current index of dp. return the
 * last day's index of dp.
 *
 */
class Solution {
	public int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[366];
		int j = 0;
		for (int i = 1; i < dp.length; i++) {
			if (j == days.length)
				break;
			if (days[j] != i)
				dp[i] = dp[i - 1];
			else {
				int day1 = i - 1 > 0 ? costs[0] + dp[i - 1] : costs[0];
				int day7 = i - 7 > 0 ? costs[1] + dp[i - 7] : costs[1];
				int day30 = i - 30 > 0 ? costs[2] + dp[i - 30] : costs[2];

				dp[i] = Math.min(day1, Math.min(day7, day30));
				j++;
			}
		}
		return dp[days[days.length - 1]];
	}
}
