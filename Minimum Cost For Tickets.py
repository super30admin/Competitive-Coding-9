#time : O(max(days))
#space: O(max(days))

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp=[0 for i in range(days[-1]+1)]
        cost=costs
        days=set(days)
        for i in range(1,len(dp)):
            if i in days:
                if(i>=30):
                    dp[i]=min(dp[i-1]+cost[0],dp[i-7]+cost[1],dp[i-30]+cost[2])
                elif(i>=7):
                    dp[i]=min(dp[i-1]+cost[0],dp[i-7]+cost[1],dp[0]+cost[2])
                else:
                    dp[i]=min(dp[i-1]+cost[0],dp[0]+cost[1],dp[0]+cost[2])
            else:
                dp[i]=dp[i-1]
        return dp[-1]
                    