// Time Complexity : O(n + maxDay), where n = no of traveling days
// Space Complexity : O(maxDay) for the DP array and HashSet
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use a HashSet to store all travel days for constant-time lookup.
//   - Use a bottom-up DP array of size `maxDay + 1` where dp[i] represents the minimum cost to cover up to day i.
//   - For each day i from 1 to maxDay:
//       • If it's not a travel day, carry forward the previous day's cost.
//       • If it's a travel day, take the minimum cost among: 1-day pass, 7-day pass, and 30-day pass.
//   - Return dp[maxDay] which contains the minimum total cost.

import java.util.HashSet;

public class MinimumCostOfTickets {
    public int mincostTickets(int[] days, int[] costs) {
        //bottom-up DP
        //we have 3 options at each day - 1 day, 7 day, 30 day pass
        //only decision making variable is days since costs array will always have 3 options only-> so use dp array and not dp matrix.
        //need set to check if we traveling particular day or not for better lookup
        HashSet<Integer> travelingDays = new HashSet<>();
        for(int day: days) {
            travelingDays.add(day);
        }
        int maxDays = days[days.length - 1];
        int[] dp = new int[maxDays + 1];    //create dp[] of size maxDays+1
        for(int i = 1; i <= maxDays; i++) {
            //check if we are traveling ith day or not using set
            if(!travelingDays.contains(i)) {    //not traveling case
                dp[i] = dp[i - 1];  //copy last day cost
                continue;
            }
            //traveling day case, get min from our 3 options of tickets
            //for each ticket, we go back that many days in dp array to get cost and add cost of that ticket type to it.
            dp[i] = Math.min(dp[i - 1] + costs[0],
                    Math.min(dp[Math.max(0, i - 7)] + costs[1],
                            dp[Math.max(0, i - 30)] + costs[2]));
        }

        //return ans from last index in dp[]
        return dp[maxDays];
    }

    public static void main(String[] args) {
        MinimumCostOfTickets solution = new MinimumCostOfTickets();

        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        int minCost = solution.mincostTickets(days, costs);
        System.out.println("Minimum cost for travel: " + minCost); // Expected output: 11
    }
}
