// In this problem, maintaining a dp array that stores minimum cost of travel upto ith day. So, to find out the min cost for each we
// have 3 options, one is take a one day ticket for that current day and add to it the cost of all the previous travels, which we 
// stored in previous one. Other option is to buy a week pass and add to it the cost of travel of all days before 1 week. And third
// take a month pass and add to it the cost of travel before a month. Take the minimum of three and store it in the cost upto current
// value. So cost of travel of all given days will be present in last cell

// Time Complexity : O(n) where n is the max day
// Space Complexity : O(n) dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Base case
        if (days == null || days.length == 0) {
            return 0;
        }
        // Pointer for checking on which days we travelled
        int pointer = 0;
        // dp array of size n+1
        int[] dp = new int[days[days.length - 1] + 1];
        // Cost before 1st day will be 0, since not travelled yet
        dp[0] = 0;
        // Loop to the length of dp
        for (int i = 1; i < dp.length; i++) {
            // Check if the days given to us at first position is 1 or greater, if greater
            // that means not travelled on day 1, so simply give the previous cost
            if (days[pointer] > i) {
                dp[i] = dp[i - 1];
                continue;
            }
            // Else increment pointer
            pointer++;
            // Compute 3 cost
            // 1 day pass
            int one = dp[i - 1] + costs[0];
            // A week pass
            int week = dp[Math.max(i - 7, 0)] + costs[1];
            // A month pass
            int month = dp[Math.max(i - 30, 0)] + costs[2]; // Note we are doing math.max bcoz if i-30 is negative, we
                                                            // can take 0 cost
            // Take minimum
            dp[i] = Math.min(one, Math.min(week, month));
        }
        // Return last cell value
        return dp[dp.length - 1];

    }
}