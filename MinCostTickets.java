import java.util.HashSet;

//Time Complexity: O(m+n) where m is the number of days and n is the number of costs
//Space Complexity: O(m) where m is the number of days

// LeetCode Problem: 983. Minimum Cost For Tickets
//Intuition: We can use dynamic programming to solve this problem. 
//We will maintain a dp array where dp[i] represents the minimum cost to travel until day i. 
// For each day, we will check if it is a valid travel day and calculate 
// the minimum cost based on the available ticket options (1-day, 7-day, and 30-day tickets).
public class MinCostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0)
            return -1;
        if (costs == null || costs.length == 0)
            return -1;
        HashSet<Integer> validDays = new HashSet<>();
        for (int day : days) {
            validDays.add(day);
        }
        int[] dp = new int[367];
        for (int i = 1; i <= 366; i++) {
            if (validDays.contains(i)) {
                int a_day = dp[Math.max(i - 1, 0)] + costs[0];
                int week = dp[Math.max(i - 7, 0)] + costs[1];
                int month = dp[Math.max(i - 30, 0)] + costs[2];
                dp[i] = Math.min(a_day, Math.min(week, month));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}