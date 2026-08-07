class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        """
        Time Complexity: O(N)
        - N is the number of elements in `days`.
        - We iterate through `days` in reverse from index (N - 1) down to 0 (N iterations).
        - Inside the loop, the `while` loops move forward in `days`, but each `while` loop 
          executes at most N times total across the entire algorithm or takes O(N) worst-case 
          per step. Since N <= 365, O(N) operations stay under ~365 steps, running in O(N) overall.

        Space Complexity: O(N)
        - We use a DP table `dp` of size (N + 1) to store the minimum costs.
        - No additional recursion stack space is required since this is an iterative bottom-up approach.
        """
        n = len(days)
        
        # dp[i] represents the minimum cost to cover all travel days from index i to the end (n - 1).
        # dp[n] = 0 serves as our base case (no travel days left to cover).
        dp = [0] * (n + 1)

        # Iterate backwards through the travel days (from last travel day to the first).
        # We work backwards so that future states (dp[nextIdx]) are already calculated when needed.
        for idx in range(n - 1, -1, -1):
            
            # --- Option 1: Buy a 1-day pass ---
            nextIdx1 = idx
            # Find the next travel day index that is NOT covered by a 1-day pass bought on days[idx].
            while nextIdx1 < n and days[nextIdx1] < days[idx] + 1:
                nextIdx1 += 1
            # Total cost = cost of 1-day pass + minimum cost to cover remaining days from nextIdx1.
            cost1 = costs[0] + dp[nextIdx1]

            # --- Option 2: Buy a 7-day pass ---
            nextIdx7 = idx
            # Find the next travel day index that is NOT covered by a 7-day pass bought on days[idx].
            while nextIdx7 < n and days[nextIdx7] < days[idx] + 7:
                nextIdx7 += 1
            # Total cost = cost of 7-day pass + minimum cost to cover remaining days from nextIdx7.
            cost7 = costs[1] + dp[nextIdx7]

            # --- Option 3: Buy a 30-day pass ---
            nextIdx30 = idx
            # Find the next travel day index that is NOT covered by a 30-day pass bought on days[idx].
            while nextIdx30 < n and days[nextIdx30] < days[idx] + 30:
                nextIdx30 += 1
            # Total cost = cost of 30-day pass + minimum cost to cover remaining days from nextIdx30.
            cost30 = costs[2] + dp[nextIdx30]

            # The minimum cost for the current index `idx` is the best choice among the 3 pass options.
            dp[idx] = min(cost1, cost7, cost30)

        # dp[0] holds the minimum cost to cover all travel days starting from index 0.
        return dp[0]