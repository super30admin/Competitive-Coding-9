# ----------------------------------------------------
# Intuition:
#
# We're given a list of travel days and 3 types of passes:
# 1-day, 7-day, and 30-day.
# The goal is to choose passes such that the total cost
# to cover all travel days is minimized.
#
#
# We solve this with:
#
# 💬 Brute Force (Naive DFS):
# - At each index, try all 3 pass options recursively.
# - Try every possible path and take minimum.
# → Time: O(3^n), Space: O(n)
#
# 💬 Memoization (Top Down):
# - Optimize brute force using memo array to cache results.
# - At each index, compute and memoize the min cost.
# → Time: O(n), Space: O(n) for memo + recursion stack
#
#
# Optimal idea: For each day, decide the most cost-effective pass.
# Use Dynamic Programming to avoid recalculating overlapping subproblems.
#
# Let dp[i] represent the minimum cost to travel from day i onward.
#
# ✅ Bottom-Up Tabulation (Optimal):
# - Build up a dp array of size 365+1 to store min cost at each day.
# - For each day:
#     → If not a travel day: dp[day] = dp[day - 1]
#     → Else: min(dp[day - 1] + cost[0], dp[day - 7] + cost[1], dp[day - 30] + cost[2])
# - Final answer is dp[last_day]
# → Time: O(365), Space: O(365)
# ----------------------------------------------------

from typing import List

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # ✅ Bottom-Up Tabulation Approach (Optimal)
        travel_days = set(days)
        last_day = days[-1]
        dp = [0] * (last_day + 1)

        for day in range(1, last_day + 1):
            if day not in travel_days:
                dp[day] = dp[day - 1]
            else:
                one_day = dp[max(0, day - 1)] + costs[0]
                seven_day = dp[max(0, day - 7)] + costs[1]
                thirty_day = dp[max(0, day - 30)] + costs[2]
                dp[day] = min(one_day, seven_day, thirty_day)

        return dp[last_day]

        # 💬 Memoization (Top-Down Recursive)
        # memo = [-1] * len(days)
        # def helper(index):
        #     if index >= len(days):
        #         return 0
        #     if memo[index] != -1:
        #         return memo[index]
        #
        #     # Option 1: 1-day pass
        #     option1 = costs[0] + helper(index + 1)
        #
        #     # Option 2: 7-day pass
        #     j = index
        #     while j < len(days) and days[j] < days[index] + 7:
        #         j += 1
        #     option2 = costs[1] + helper(j)
        #
        #     # Option 3: 30-day pass
        #     j = index
        #     while j < len(days) and days[j] < days[index] + 30:
        #         j += 1
        #     option3 = costs[2] + helper(j)
        #
        #     memo[index] = min(option1, option2, option3)
        #     return memo[index]
        # return helper(0)

        # 💬 Brute Force DFS (Naive)
        # def dfs(index):
        #     if index >= len(days):
        #         return 0
        #     # Option 1
        #     cost1 = costs[0] + dfs(index + 1)
        #     # Option 2
        #     j = index
        #     while j < len(days) and days[j] < days[index] + 7:
        #         j += 1
        #     cost7 = costs[1] + dfs(j)
        #     # Option 3
        #     j = index
        #     while j < len(days) and days[j] < days[index] + 30:
        #         j += 1
        #     cost30 = costs[2] + dfs(j)
        #     return min(cost1, cost7, cost30)
        # return dfs(0)


# Main function for testing
if __name__ == "__main__":
    solution = Solution()

    days1 = [1, 4, 6, 7, 8, 20]
    costs1 = [2, 7, 15]
    print(f"Min cost for days {days1}: {solution.mincostTickets(days1, costs1)}")  # Expected: 11

    days2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31]
    costs2 = [2, 7, 15]
    print(f"Min cost for days {days2}: {solution.mincostTickets(days2, costs2)}")  # Expected: 17

    days3 = [1, 15, 30, 60, 90, 120, 150, 180, 210, 240, 270, 300, 330, 360]
    costs3 = [3, 8, 20]
    print(f"Min cost for days {days3}: {solution.mincostTickets(days3, costs3)}")  # Case dependent
