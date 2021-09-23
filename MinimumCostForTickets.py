"""
Time Complexity : O(n) where n is length of the days array
Space Complexity : O(n) where n is length of days array
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [float('inf')]*(days[-1]+1)
        dp[0] = 0
        # For all number of days travelled we mark 0 in dp array
        for day in days:
            dp[day] = 0
        # We traverse through the dp array and calculate the min cost between the 1, 7
        # and 30 day travel else if it is 'inf' then we simply copy the cost of 
        # previous day
        for d in range(1, days[-1]+1):
            if dp[d] == float('inf'):
                dp[d] = dp[d - 1]
            else:
                dp[d] = dp[d - 1] + costs[0]
                dp[d] = min(dp[d], dp[max(0, d - 7)] + costs[1])
                dp[d] = min(dp[d], dp[max(0, d - 30)] + costs[2])
        return dp[-1]