# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# Approach:
# At each index we calcualte the most optimal path to move forward.

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        n = max(days)
        
        dp = [0]*(n+1)
        
        for i in range(1, n+1):
            
            if i not in days:
                dp[i] = dp[i-1]
                continue
            
            dp[i] = min(costs[0]+dp[i-1], costs[1]+dp[max(i-7,0)], costs[2]+dp[max(i-30,0)])
        
        return dp[-1]