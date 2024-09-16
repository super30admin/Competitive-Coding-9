#Time complexity: O(365)
#Space complexity: O(365)

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = days[len(days)-1]
        dp = [0 for _ in range(n+1)]
        
        hSet = set()
        for day in days:
            hSet.add(day)
        
        for i in range(1, len(dp)):
            if i in hSet:
                dp[i] = min(dp[i-1]+costs[0], dp[max(0,i-7)]+costs[1], dp[max(0,i-30)]+costs[2])
            else:
                dp[i] = dp[i-1]
                
        return dp[n]
            
        
