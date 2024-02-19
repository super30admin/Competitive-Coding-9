# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode :yes

from ast import List


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * (days[-1] + 1)  # Create a DP array of length equal to the last day in days list
        hash_set = set(days)
        return self.helper(days, costs, 1, dp, hash_set)  # Start from day 1
    
    def helper(self, days, costs, day, dp, hash_set):
        if day > days[-1]:  # Base case: If the current day exceeds the last travel day, return 0
            return 0
        
        if dp[day] != 0:  # If the cost for the current day is already computed, return it
            return dp[day]
        
        if day in hash_set:  # If the current day is a travel day
            # Compute the cost for 1-day, 7-day, and 30-day passes
            cost1 = costs[0] + self.helper(days, costs, day + 1, dp, hash_set)
            cost2 = costs[1] + self.helper(days, costs, day + 7, dp, hash_set)
            cost3 = costs[2] + self.helper(days, costs, day + 30, dp, hash_set)
            # Update the DP array with the minimum cost for the current day
            dp[day] = min(cost1, cost2, cost3)
        else:
            # If the current day is not a travel day, simply move to the next day
            dp[day] = self.helper(days, costs, day + 1, dp, hash_set)
        
        return dp[day]

