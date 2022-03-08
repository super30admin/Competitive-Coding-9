# Time complexity : O(n), where n is the max day in the travel plan
# Space Complexity: O(n)

from typing import List


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        max_day = days[-1]
        d = {}
        for day in days:
            d[day] = 1

        dp = [0] * (max_day + 1)

        for i in range(1, len(dp)):
            c1 = dp[i - 1]
            c7 = dp[i - 7] if (i - 7) > 0 else 0
            c30 = dp[i - 30] if (i - 30) > 0 else 0

            if i in d:
                dp[i] = min(c1 + costs[0], c7 + costs[1], c30 + costs[2])
            else:
                dp[i] = dp[i - 1]

        return dp[-1]
