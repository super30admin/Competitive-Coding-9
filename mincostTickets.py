# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        dp = [0] * (n + 1)  # dp[i]: min cost to cover days[i:]
        durations = [1, 7, 30]
        
        for i in range(n - 1, -1, -1):
            dp[i] = float('inf')
            for cost, duration in zip(costs, durations):
                j = i
                # Find the next day not covered by this pass
                while j < n and days[j] < days[i] + duration:
                    j += 1
                dp[i] = min(dp[i], cost + dp[j])
        return dp[0]
        