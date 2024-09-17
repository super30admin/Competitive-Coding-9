# TC: O(days[days.length-1])

# SC: O(days[days.length-1])

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        dp = [float("inf")] * (days[-1] + 1)
        dp[0] = 0
        passes = {0:1, 1:7, 2:30}
        
        # days = [1,4,6,7,8,20]
        prev = 0
        for d in days:
            for j in range(prev, d):
                # print(j)
                dp[j] = dp[prev]
            for k in range(len(costs)):
                prevDay = max(0, d - passes[k])
                #print(dp[d], dp[prevDay])
                dp[d] = min(dp[d], dp[prevDay] + costs[k])
            
            prev = d
        
        #print(dp)
        return dp[-1]
        