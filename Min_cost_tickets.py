# Time complexity : O(max(num) + 1)
# Space complexity : O(max(num) + 1)
# Leetcode : Solved and submitted

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # find the max
        max_days = days[-1] + 1
        
        # create a dp array of size max_days + 1
        dp = [0 for _ in range(max_days)]
        d1 = d7 = d30 = 0
        
        # creating a set to check for days that we are travelling on
        day = set(days)
        
        for i in range(max_days):
           # if i is the way that we are travelling, then we have three choices to choose from, so we chose the min out of all the costs
            if i in day:
                d1 = dp[i-1] + costs[0]
                d7 = dp[max(0,i-7)] + costs[1]
                d30 = dp[max(0,i-30)] + costs[2]
            dp[i] = min(d1, min(d7, d30))
        
        # return the dp of the last index as that would be the cost of travelling through all days
        return dp[max_days - 1]
