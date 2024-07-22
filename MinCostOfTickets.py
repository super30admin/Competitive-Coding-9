# Time Complexity : O(n), where n is the number of days
# Space Complexity : O(n)

from typing import List

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days:
            return 0
        
        last_day = days[-1]
        days_included = [False] * (last_day + 1)
        max_cost = [0] * (last_day + 1)

        for day in days:
            days_included[day] = True

        for i in range(1, last_day + 1):
            if not days_included[i]:
                max_cost[i] = max_cost[i - 1]
                continue

            min_cost = float('inf')

            min_cost = min(min_cost, max_cost[i - 1] + costs[0])  # daily pass
            min_cost = min(min_cost, max_cost[max(0, i - 7)] + costs[1])  # weekly pass
            min_cost = min(min_cost, max_cost[max(0, i - 30)] + costs[2])  # monthly pass
            max_cost[i] = min_cost

        return max_cost[last_day]

# Examples

solution = Solution()

# Example 1
days1 = [1, 4, 6, 7, 8, 20]
costs1 = [2, 7, 15]
print(solution.mincostTickets(days1, costs1))  # Output: 11

# Example 2
days2 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31]
costs2 = [2, 7, 15]
print(solution.mincostTickets(days2, costs2))  # Output: 17

# Example 3
days3 = [1, 15, 30, 45]
costs3 = [3, 9, 25]
print(solution.mincostTickets(days3, costs3))  # Output: 12