# Time complexity - O(D) (where D : last value in the days list)
# Space Complexity: O(D) (where D : last value in the days list)
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : for every day we check if it is feasible to go for one or 7 day or 30 day pass. always check for min/cheaper option.

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        
        days_set = set (days)
        num = days[-1]
        dp = [0]*(num+1)
        
        for i in range(num+1):
            if i not in days_set:
                dp[i] = dp[i-1]
                
            else:
                dp[i] = min(dp[i-1]+costs[0],dp[max(i-7,0)]+costs[1],dp[max(i-30,0)] +costs[2])
                
        return dp[i]