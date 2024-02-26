import java.util.HashSet;
import java.util.Set;

public class MinCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        // return mincostTicketsMemoization(days, costs);
        return mincostTicketsDP(days, costs);
    }

    // TC: O(N) where N is length of days array
    // SC: O(N) where N is length of days array
    private int mincostTicketsDP(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        int index = 0;
        for (int day = 1; day <= lastDay; day++) {
            if (day < days[index]) {
                dp[day] = dp[day - 1];
            } else {
                index++;
                dp[day] = Math.min(costs[0] + dp[day - 1],
                        Math.min(costs[1] + dp[Math.max(0, day - 7)],
                                costs[2] + dp[Math.max(0, day - 30)]));
            }
        }
        return dp[lastDay];
    }

    // TC: O(N) where N is length of days array
    // SC: O(N) where N is length of days array
    private int mincostTicketsMemoization(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int day : days) {
            daySet.add(day);
        }
        int lastDay = days[days.length - 1];
        int[] memo = new int[lastDay + 1];
        return helper(days, costs, 1, daySet, memo);
    }

    private int helper(int[] days, int[] costs, int currDay, Set<Integer> daySet, int[] memo) {
        if (currDay > days[days.length - 1]) return 0;
        if (!daySet.contains(currDay)) {
            return helper(days, costs, currDay + 1, daySet, memo);
        }
        if (memo[currDay] != 0) return memo[currDay];
        int oneDay = costs[0] + helper(days, costs, currDay + 1, daySet, memo);
        int sevenDay = costs[1] + helper(days, costs, currDay + 7, daySet, memo);
        int thirtyDay = costs[2] + helper(days, costs, currDay + 30, daySet, memo);
        memo[currDay] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        return memo[currDay];
    }
}
