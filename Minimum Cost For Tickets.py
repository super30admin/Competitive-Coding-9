""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp=[0 for i in range(days[-1]+1)]
        for i in range(1,len(dp)):
            if i in days:
                dp[i]=min((dp[i-1]+costs[0]),(dp[max(i-7,0)]+costs[1]),(dp[max(i-30,0)]+costs[2]))
            else:
                dp[i]=dp[i-1]

        return dp[-1]