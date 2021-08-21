#Approach: DP
"""
TC: O(n) | n -> last/max day of travel. It can also be O(1) as we have 365 days
SC: O(n)
"""
class Solution:
    def mincostTickets(self, days: List[int], cost: List[int]) -> int:
        
        dp = [0]*(days[-1]+1) # ie 0 to max day
        ways = [1, 7 ,30]
        days = set(days)
        for i in range(1, len(dp)):
            if i not in days:
                dp[i] = dp[i-1] 
            else:
                dp[i] = dp[i-1] + cost[0]
                # dp[max(i-ways[1],0)] + cost[1],
                # dp[max(i-ways[2],0)] + cost[2])
                
                if i >= ways[1]:
                    dp[i] = min(dp[i], dp[i-ways[1]] + cost[1])
                else:
                    dp[i] = min(dp[i], cost[1]) 

                if i >= ways[2]:
                    dp[i] = min(dp[i], dp[i-ways[2]] + cost[2])
                else:
                    dp[i] = min(dp[i], cost[2])

        return dp[-1]