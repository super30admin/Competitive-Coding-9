"""
You have planned some train traveling one year in advance. 
The days of the year in which you will travel are given as an 
integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, 
then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel 
every day in the given list of days.
"""

# Time Complexity : O(n) n = max(day)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        if not days or len(days) == 0:
            return 0

        dayset = set(days)

        dp = [0 for _ in range(max(days) + 1)]

        for i in range(1, len(dp)):

            if i not in dayset:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(dp[i - 1] + costs[0],
                            dp[max(0, i - 7)] + costs[1],
                            dp[max(0, i - 30)] + costs[2])

        return dp[-1]