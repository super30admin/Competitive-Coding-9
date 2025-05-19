class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        """
        Approach:
        1. Use bottom-up dynamic programming to calculate the minimum cost of covering all travel days.
        2. dp[i] = min cost to cover travel from days[i] to the end.
        3. For each day[i], try buying a 1-day, 7-day, or 30-day pass:
            - Use a while loop to find the index `j` where the current pass would no longer be valid.
            - Update dp[i] with: cost of current pass + dp[j].
        4. Result will be in dp[0] (cost to cover all days from the start).

        Time Complexity: O(n * 3) ≈ O(n), where n is the number of travel days.
                         For each day, at most 3 passes are checked.
        Space Complexity: O(n) — for the dp array of size len(days) + 1.
        """
        dp = [0] * (len(days) + 1)

        for i in range(len(days) - 1, -1, -1):
            j = i
            dp[i] = float('inf')
            for cost, duration in zip(costs, [1, 7, 30]):
                while j < len(days) and days[j] < days[i] + duration:
                    j += 1
                dp[i] = min(dp[i], cost + dp[j])

        return dp[0]
