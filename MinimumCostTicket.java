/**
 * Time Complexity: O(N), N is number of days
 * Space Complexity: O(N), recursive stack space
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 * Approach:
 * Using the top down approach and recursion to find minimal cost utilizing the costs from all 3 options
 */

public class MinCostTicket {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }

        int lastDay = days[days.length - 1];
        boolean[] allDays = new boolean[lastDay + 1];
        for (int day: days) {
            allDays[day] = true;
        }

        int[] memo = new int[lastDay + 1];
        Arrays.fill(memo, -1);

        return recursion(0, allDays, costs, memo);
    }

    private int recursion(int index, boolean[] days, int[] costs, int[] memo) {
        // base
        if (index > days.length - 1) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        if (!days[index]) {
            return recursion(index + 1, days, costs, memo);
        }

        // logic
        int sum1 = recursion(index + 1, days, costs, memo) + costs[0];
        int sum7 = recursion(index + 7, days, costs, memo) + costs[1];
        int sum30 = recursion(index + 30, days, costs, memo) + costs[2];

        memo[index] = Math.min(sum1, Math.min(sum7, sum30));
        return memo[index];
    }