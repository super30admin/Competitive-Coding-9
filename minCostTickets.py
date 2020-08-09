# Time Complexity : O(1), max number of days 366
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

# This is a DP approach where the minimum cost for all days is stored
# while considering the costs of the three different types of tickets,
# at the end the last spot will be the overall minimum cost.
class Solution(object):
    def mincostTickets(self, days, costs):
        s = set(days)
        dMax = days[len(days) - 1]
        dp = [0] * (dMax + 1)

        for i in range(1, len(dp)):
            if i not in s:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(dp[i - 1] + costs[0],
                            dp[max(i - 7, 0)] + costs[1],
                            dp[max(i - 30, 0)] + costs[2])

        return dp[-1]
