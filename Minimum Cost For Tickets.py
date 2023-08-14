#TC: O(Max(days)) = O(365) at worst
#SC: O(Max(days)) = O(365) at worst
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        dp = [0]*(days[n-1]+1)
        days = set(days)     
        for i in range(1,len(dp)):        
            if i in days:
                dp[i] = min(dp[max(i-1,0)]+costs[0],dp[max(i-7,0)]+costs[1],dp[max(i-30,0)]+costs[2])
            else:
                dp[i]=dp[i-1]
        return dp[len(dp)-1]