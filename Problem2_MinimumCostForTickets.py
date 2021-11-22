# Time Complexity: O(n), where n is the max numbered day in the input array
# Space Complexity: O(n)
# Approach: DP

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days or len(days) == 0:
            return 0

        # Set to check if we are travelling in a particular day
        dayset = set(days)

        # dp array with size - max numbered day
        dp = [0 for x in range(max(days) + 1)]

        for i in range(1, len(dp)):
            # If not travelling in that particular day
            if i not in dayset:
                dp[i] = dp[i - 1]
            # If travelling, find the min cost to travel among 2, 7 and 30 day pass
            else:
                dp[i] = min(dp[i - 1] + costs[0],
                            dp[max(0, i - 7)] + costs[1],
                            dp[max(0, i - 30)] + costs[2])

        # Last index will give the minimum cost needed to travel on the days given in the input list
        return dp[-1]
