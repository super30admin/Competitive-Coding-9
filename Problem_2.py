"""
Problem : 2

Time Complexity :
Approach 1 - O(3^n)
Approach 2 - O(n)

Space Complexity :
Approach 1 - O(3^n)
Approach 2 - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


# Minimum cost for tickets

# Approach - 1
# Bruteforce/DFS

class Solution(object):
    def __init__(self):
        self.minn=float('inf')
        self.hset=set()
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        for day in days:
            self.hset.add(day)
        self.helper(days,costs,0,0)
        return self.minn
    def helper(self,days,costs,currCost,idx):
        if idx>days[-1]:
            self.minn=min(self.minn,currCost)
            return
        if currCost>self.minn:
            return
        if idx not in self.hset:
            self.helper(days,costs,currCost,idx+1)
        else:
            self.helper(days,costs,currCost+costs[0],idx+1)
            self.helper(days,costs,currCost+costs[1],idx+7)
            self.helper(days,costs,currCost+costs[2],idx+30)
            

# Approach - 2
# DP

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

