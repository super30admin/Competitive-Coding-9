# 983. Minimum Cost For Tickets

# Code: DP "Similar to coin change"


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        dp = [0 for i in range(max(days)+1)]
        
        days = list(set(days))
        # print(days)
        
        for i in range(1, len(dp)):
            # print(dp)
            if i not in days:
                dp[i] = dp[i-1]
            else:
                dp[i] = min(dp[max(i-1, 0)]+costs[0] , min(dp[max(i-7, 0)]+costs[1], dp[max(i-30, 0)]+costs[2]))
        
        # print(dp)
        return dp[-1]


# Time Complexity: O(N)
# Spac Complexity: O(max day+1 in days List)
# Accpeted on leetcode: Yes