# Time Complexity : O(D) where D is last day of travel within 365 days
# Space Complexity : O(D)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0 for _ in range(max(days) + 1)]
        j = 0
        for i in range(1, len(dp)):
            if i == days[j]:
                if i - 7 < 0:
                    dp[i] = min(dp[i-1] + costs[0], costs[1], costs[2])
                elif i - 30 < 0:
                    dp[i] = min(dp[i-1] + costs[0], dp[i-7] + costs[1], costs[2]) 
                else:
                    dp[i] = min(dp[i-1] + costs[0], dp[i-7] + costs[1], dp[i-30] + costs[2])
                j += 1
            else:
                dp[i] = dp[i - 1]

        return dp[-1]