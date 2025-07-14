# // Time Complexity : o(n) where n is the number of days
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# idea is to try all the combination of package on the days array keep track of them in  a cache for repeated subproblems along with the min and return them in the end

from typing import List
# class Solution:
#     def mincostTickets(self, days: List[int], costs: List[int]) -> int:
#         n = len(days)
#         memo = [-1]*n
#         def helper(i,days,costs):
#             # base
#             if i == len(days): return 0
#             if memo[i]!=-1: return memo[i]
#             mincost = float('inf')
#             # logic
#             package = [1,7,30]
#             for idx,p in enumerate(package):
#                 k = i
#                 while k<len(days) and days[k] < days[i]+p:
#                     k+=1
#                 mincost = min(mincost,costs[idx]+helper(k,days,costs))
#             memo[i] = mincost
#             return mincost
#         return helper(0,days,costs)

# class Solution:
#     def mincostTickets(self, days: List[int], costs: List[int]) -> int:
#         n = len(days)
#         dp = [0]*(n+1)
#         for i in range(n-1,-1,-1):
#             dp[i] = float('inf')
#             for idx,p in enumerate([1,7,30]):
#                 j = i
#                 while j<n and days[j]<days[i]+p:
#                     j+=1
#                 dp[i] = min(dp[i], costs[idx] + dp[j])
#         return dp[0]

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        dp = [0]*(n+1)
        for i in range(n-1,-1,-1):
            dp[i] = float('inf')
            for cost,duration in zip(costs,[1,7,30]):
                j = i
                while j<n and days[j]<days[i]+duration:
                    j+=1
                dp[i] = min(dp[i], cost + dp[j])
        return dp[0]
                
                
    


        