#Time complexity : O(N) where N is max day in the days

#Space complexity : O(N)

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        last_day = days[-1]
        total_days = range(last_day+1)
        dp = [0]*(last_day+1)
        for i in total_days:
            if i not in days:
                dp[i] = dp[i-1]
                
            else:
                dp[i] = min(costs[0]+dp[i-1],dp[max(0,i-7)]+costs[1],dp[max(0,i-30)]+costs[2])
        return dp[-1]