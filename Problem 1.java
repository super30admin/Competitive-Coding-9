//Time Complexity: O(n) where n is the number of days in days array
//Space Complexity: O(n)

//Successfully runs on leetcode: 1 ms

//Approach: Here DP(i) is the minimum cost of buying tickets on the days before ith day. If the ith day is not in the days
//array i.e. we do not need tickets for the ith day, then we will make dp(i) = dp(i-1) else we will try to find the minimum cost
//if we buy ticket for 1 day, 7 day pass and 30 day pass. The cost on the last day will be the minimum cost required.


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
    Set<Integer> set = new HashSet<>();
    for (int day : days) set.add(day);

    int lastDay = days[days.length-1], dp[] = new int[lastDay+1];
    for (int i = 1; i <= lastDay; i++) {
        if (!set.contains(i)) {
            dp[i] = dp[i-1];
        }
        else {
            dp[i] = dp[i-1]+costs[0];

            int j = (i >= 7) ? i-7 : 0;
            dp[i] = Math.min(dp[i], dp[j] + costs[1]);

            j = (i >= 30) ? i-30 : 0;
            dp[i] = Math.min(dp[i], dp[j] + costs[2]);
        }
    }

    return dp[lastDay];
    }
}