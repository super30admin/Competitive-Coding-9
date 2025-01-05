//983. Minimum cost for Tickets - https://leetcode.com/problems/minimum-cost-for-tickets/description/
//Time Complexity: O(1)
//Space Complexity: O(n) ~ size of days array

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < days.length; i++){
            daySet.add(days[i]);
            max = Math.max(max, days[i]);
        }
        int[] dp = new int[max+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            if(!daySet.contains(i)){
                //non traveling days has no additional cost
                //just the prev day cost is copied
                dp[i] = dp[i-1];
                continue;
            }
            //else, min of (7day pass + cost of same day, 30day pass+cost)
            int temp = Math.min(dp[Math.max(0,i-7)] + costs[1], dp[Math.max(0,i-30)] + costs[2]);
            dp[i] = Math.min(dp[i-1] + costs[0], temp);
        }
        return dp[dp.length - 1];
    }
}