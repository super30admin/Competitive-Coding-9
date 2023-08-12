"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Minimum cost for tickets

class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        daySet=set()
        for i in range(len(days)):
            daySet.add(days[i])
        
        dp=[0 for _ in range(days[-1]+1)]

        for i in range(1,len(dp)):
            if i not in daySet:
                dp[i]=dp[i-1]
                continue
            dp[i]=min(dp[i-1]+costs[0],min(dp[max(0,i-7)]+costs[1],dp[max(0,i-30)]+costs[2]))
        return dp[-1]