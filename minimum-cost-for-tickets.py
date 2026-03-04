''' Time Complexity : O(n) : n is last day of travel 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No
'''
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = days[-1]
        m = len(costs)

        dp = [0] * (n+1)
        idx = 0
        for i in range(1,n+1):
            if i < days[idx]:
                dp[i] = dp[i-1]
                continue
            dp[i] = min((dp[i-1] + costs[0]), (dp[max(0,i-7)] + costs[1]), (dp[max(0,i-30)] + costs[2]))
            idx += 1
        return dp[n]