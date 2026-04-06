# Time Complexity : O(lastDay)
# Space Complexity : O(lastDay)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use tabulation to fill a dp array from day 1 to the last travel day.
# On non-travel days, we carry over the previous cost; on travel days, we try all 3 pass options.
# At each travel day, we pick the minimum cost among 1-, 7-, or 30-day passes using the table.

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        lastDay = days[-1]
        dp = [0] * (lastDay + 1)

        i = 0

        for day in range(1, lastDay + 1):
            if day < days[i]:
                dp[day] = dp[day-1]
            else:
                dp[day] = min(dp[day-1] + costs[0], min(dp[max(0, day-7)] + costs[1], dp[max(0, day-30)] + costs[2]))
                i += 1

        return dp[lastDay]
        