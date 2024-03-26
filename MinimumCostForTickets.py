'''
TC: O(n) - n is the max day
SC: O(n) - total space for the the last day 
            but can also be taken as O(1) since it can go max to 365 days
'''
from typing import List

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0]*(days[-1]+1)
        for i, day in enumerate(dp):
            if i == 0:
                continue
            if i in days:
                if (i-1)>=0 and (i-7)>=0 and (i-30)>=0:
                    dp[i] = min(dp[i-1] + costs[0], dp[i-7] + costs[1], dp[i-30] + costs[2])      
                elif (i-1)>=0 and (i-7)>=0:
                    dp[i] = min(dp[i-1] + costs[0], dp[i-7] + costs[1], costs[2])  
                elif (i-1)>=0:
                    dp[i] = min(dp[i-1] + costs[0], costs[1], costs[2])  
                else:
                    dp[i] = min(costs[0], costs[1], costs[2])  
            else:
                dp[i] = dp[i-1] 
        return dp[-1]
s = Solution()
print(s.mincostTickets([1,4,6,7,8,20], [2,7,15]))
print(s.mincostTickets([1,2,3,4,5,6,7,8,9,10,30,31], [2,7,15]))