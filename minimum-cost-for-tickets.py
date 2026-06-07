# Time Complexity: O(n) where n is the last day we need to travel 
# Space Complexity: O(n) where n is the last day we need to travel  
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """

        maxday=days[-1]
        setdays=set(days)
        dp=[-1]*(maxday+1)

        def helper(currday):
            if currday>maxday: 
                return 0
            if currday not in setdays:
                dp[currday] = helper(currday+1) 
                return dp[currday]
            if dp[currday]!=-1:
                return dp[currday]

            a=costs[0]+helper(currday+1)
            b=costs[1]+helper(currday+7)
            c=costs[2]+helper(currday+30)

            dp[currday] = min(a,b,c)
            return dp[currday]
        
        dp[1] = helper(1)
        return dp[1]