# Time Complexity : O(D) D = max Value in days[]
# Space Complexity : O(D) D = max Value in days[]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        maxVal = days[-1]
        dp = [0 for i in range(maxVal+1)]
        
        for i in range(1, len(dp)):
            if i not in days:
                dp[i] = dp[i-1]
            else:
                dp[i] = min(dp[i-1] + costs[0],
                           dp[max(i-7,0)] + costs[1],
                           dp[max(i-30,0)] + costs[2])
                
        return dp[-1]