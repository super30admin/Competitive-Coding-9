"""
Implemented using a bottom-up dynamic programming approach. At each day, I consider buying a 1-day, 7-day, or 30-day pass and calculate the minimum total cost from that point onward. I iterate backward through the days list, storing the minimum cost in the dp array.
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:

        size = len(days)
        dp = [0] * (size + 1)
        durations = [1,7,30]

        for i in range(size - 1, -1, -1):
            dp[i] = float("inf")
            for j in range(3):
                cost = costs[j]
                duration = durations[j]
                ptr = i
                while ptr < size and days[ptr] < days[i] + duration:
                    ptr += 1
                dp[i] = min(dp[i], cost + dp[ptr])
        return dp[0]    