# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        durations = [1, 7, 30]  # Durations of the passes
        
        dp = [0] * (n + 1)  # Initialize DP array
        
        for i in range(1, n + 1):
            dp[i] = float('inf')  # Initialize to a large value
            for j in range(3):
                prev_day = days[i - 1] - durations[j]  # Calculate the previous day covered by the pass
                k = i - 1
                while k >= 0 and days[k] > prev_day:
                    k -= 1
                dp[i] = min(dp[i], dp[k + 1] + costs[j])
        
        return dp[n]
