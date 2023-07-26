'''
Problem: Minimum Cost For Tickets
Time Complexity: O(n), where n is maximum day
Space Complexity: O(n) for dp array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Bottom UP DP
        every dp cell is filled using minimum of cost of 1 day, 7 day or 30 day  
'''

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)

        daystraveled = set(days)

        maxday = days[n-1]

        dp=[0 for _ in range(maxday+1)]

        for i in range(1, maxday+1):
            if i in daystraveled:
                #get minimum of three
                one = dp[i-1] + costs[0]
                seven = dp[max(0, i-7)] + costs[1]
                thirty = dp[max(0, i-30)] + costs[2]
                dp[i] = min(one, seven, thirty)
            else:
                #get previous cost
                dp[i] = dp[i-1]
        
        return dp[maxday]
