# Time Complexity : O(N) where N is the number of days
# Space Complexity : O(N) as stack space is used for recursion and dp array of size N
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using recursion with memoization to solve this problem. I am going with memoization to store the previously computed results for each index in days array.
# This way I can avoid recomputing the results for the same index multiple times and thus optimize the solution.
# The dp array is used to store the minimum cost for each index in days array.
# The helper function takes the current index from the days array and computes the minimum cost 
# to cover all the days from that index to the end of the days array. So I am iterating through each of the three ticket options (1-day, 7-day, 30-day)
# and for each option, I am finding the next index in the days array that is not covered by the current ticket.
# I am then recursively calling the helper function for that next index and adding the cost of the current ticket to the result of the recursive call.
# Finally, I am taking the minimum of all the computed costs for the three ticket options and storing it in the dp array for the current index.
# The base case for the recursion is when the current index is greater than or equal to the length of the days array, in which case I return 0 as there are no more days to cover.

from typing import List
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        durations = [1,7,30]
        dp = [-1]*len(days)
        def helper(idx):
            if idx >= len(days):
                return 0
            if dp[idx] != -1:
                return dp[idx]
            miny = float('inf')
            for cost, duration in zip(costs, durations):
                next_idx = idx
                while next_idx < len(days) and days[next_idx] <= days[idx] + duration - 1:
                    next_idx += 1
                totalcost = cost+helper(next_idx)
                miny = min(totalcost,miny)
            dp[idx] = miny
            return dp[idx]
        return helper(0)

        

        