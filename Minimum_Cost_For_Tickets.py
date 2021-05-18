class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        if not days:
            return 0
        
        dp = [0]* (days[-1] +1)
        print(dp)
        for i in range(1,len(dp)):
            if i in days:
                dp[i] = min(dp[i-1] + costs[0], min(dp[max(i-7, 0)] + costs[1],dp[max(i-30, 0)] + costs[2]))
            else:
                dp[i] = dp[i-1]  
        print(dp)
        return dp[-1]
