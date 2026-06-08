// Time Complexity : o(n) where n is the last day in the days array
// Space Complexity :   o(n) where n is the last day in the days array
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can use dynamic programming to solve this problem. We will create a dp array where dp[i] represents the minimum cost to cover all the days up to day i. We will iterate through each day from 1 to the last day in the days array. If the current day is not in the set of travel days, we can simply copy the cost from the previous day (dp[i] = dp[i - 1]). If the current day is a travel day, we will calculate the cost for three options: buying a 1-day pass, a 7-day pass, and a 30-day pass. We will take the minimum of these three options and store it in dp[i]. Finally, we will return dp[lastDay] which will give us the minimum cost to cover all the travel days.
// We will use a HashSet to store the travel days for O(1) lookups. The dp array will be of size lastDay + 1 to accommodate all days up to the last travel day. We will iterate through each day and update the dp array based on whether it is a travel day or not, and the costs of the different pass options. This approach ensures that we are calculating the minimum cost for each day based on the previous calculations, leading to an efficient solution.
//  This approach ensures that we are calculating the minimum cost for each day based on the previous calculations, leading to an efficient solution. By iterating through each day and updating the dp array accordingly, we can find the minimum cost to cover all the travel days in a single pass through the dp array, resulting in a time complexity of O(n) where n is the last day in the days array. The space complexity is also O(n) due to the dp array storing the minimum cost for each day up to the last travel day.
// We will return dp[lastDay] which will give us the minimum cost to cover all the travel days, ensuring that we have considered all possible combinations of pass purchases to minimize the total cost.
// We will return dp[lastDay] which will give us the minimum cost to cover all the travel days, ensuring that we have considered all possible combinations of pass purchases to minimize the total cost. This dynamic programming approach allows us to efficiently compute the minimum cost while considering the different pass options and their respective durations, ultimately leading to an optimal solution for the problem.
// By iterating through each day and updating the dp array based on whether it is a travel day or not, and the costs of the different pass options, we can find the minimum cost to cover all the travel days in a single pass through the dp array, resulting in a time complexity of O(n) where n is the last day in the days array. The space complexity is also O(n) due to the dp array storing the minimum cost for each day up to the last travel day.

import java.util.*;

class Solution {

    public int mincostTickets(int[] days, int[] costs) {

        HashSet<Integer> set = new HashSet<>();

        for (int day : days) {
            set.add(day);
        }

        int lastDay = days[days.length - 1];

        int[] dp = new int[lastDay + 1];

        dp[0] = 0;

        for (int i = 1; i <= lastDay; i++) {

            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            int cost1 = costs[0] + dp[Math.max(i - 1, 0)];
            int cost7 = costs[1] + dp[Math.max(i - 7, 0)];
            int cost30 = costs[2] + dp[Math.max(i - 30, 0)];

            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }

        return dp[lastDay];
    }
}