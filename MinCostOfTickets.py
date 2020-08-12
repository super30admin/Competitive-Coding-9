--------------------------Min Cost  of Tickets------------------------------------------
# Time Complexity : O(N) as N is length of unique days in 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we will calculate the cost of each day by taking the minimum amount will take until this day from previous days will
# types of tickets. We will take the cost if the day is greater than 0 and day in days list else we will take the previous cost of the ticket.


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days or not costs:
            return 0
        
        s = set(days)
        m = max(days)
        
        dp = [0 for i in range(m+1)]
        dp[0] = 0
        
        for i in range(1, m+1):
            if i in s:
                dp[i] = min(dp[i-1]+costs[0], dp[max(i-7, 0)]+costs[1], dp[max(i-30, 0)]+costs[2])
            else:
                dp[i] = dp[i-1]
        return dp[-1]