class Solution:
    def mincostTickets(self, days, costs) :

        dp = [-1 for i in range(max(days) + 1)]
        dp[0] = 0

        for day in days:
            dp[day] = 0

        for i in range(1, max(days) + 1):
            if dp[i] == -1:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(dp[i - 1] + costs[0], dp[max(i - 7, 0)] + costs[1], dp[max(i - 30, 0)] + costs[2])

        return dp[max(days)]