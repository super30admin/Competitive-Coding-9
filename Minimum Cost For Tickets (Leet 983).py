'''
Using DP
Time: O(n)
Space: O(n)
'''

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if days is None:
            return None
        
        temp = set(days)
        
        res = 0
        
        dp = [0 for _ in range(days[-1]+1)]
        
        for i in range(1,len(dp)):
            if i in temp:
                dp[i] = min(
                            dp[max(i-1,0)]+costs[0],
                            dp[max(i-7,0)]+costs[1],
                            dp[max(i-30,0)]+costs[2]
                           )
            else:
                dp[i] = dp[i-1]
        
        return dp[-1]