class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        #Approach: Dynamic Programming
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the last day in the given array 'days'
        
        dp = [0 for _ in range(days[-1] + 1)]
        days = set(days)
        
        for i in range(1, len(dp)):
            if i in days:
                if i >= 30:
                    dp[i] = min(costs[0] + dp[i-1], costs[1] + dp[i-7], costs[2] + dp[i-30])
                elif i >= 7:
                    dp[i] = min(costs[0] + dp[i-1], costs[1] + dp[i-7], costs[2])
                else:
                    dp[i] = min(costs[0] + dp[i-1], costs[1], costs[2])
            
            else:
                dp[i] = dp[i-1]
        
        return dp[-1]