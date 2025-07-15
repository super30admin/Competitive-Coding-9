# Time Complexity: O(K) where K is the size of the dp array and we need to iterate through K days
# Space Complexity: O(K)

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        lastD = days[-1]
        dp = [0] * (lastD + 1)
        day_set = set(days)  # Faster lookup for travel days

        for day in range(1, lastD + 1):
            if day not in day_set:
                dp[day] = dp[day - 1]
            else:
                dp[day] = min(
                    dp[day - 1] + costs[0],                     # 1-day pass
                    dp[max(0, day - 7)] + costs[1],             # 7-day pass
                    dp[max(0, day - 30)] + costs[2]             # 30-day pass
                )

        return dp[lastD]
      