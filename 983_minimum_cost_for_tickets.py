"""
Approach: Dynamic Programming
Time Complexity: O(W), where W =365 is the maximum numbered day in your travel plan.
Space Complexity: O(W).
"""

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # index of ticket
        _1day_pass, _7day_pass, _30day_pass = 0, 1, 2

        # Predefined constant to represent not-traverling day
        not_traveling_Day = -1

        # DP Table, record for minimum cost of ticket to travel
        dp_cost = [not_traveling_Day for _ in range(366)]

        # base case:
        # no cost before travel
        dp_cost[0] = 0

        for day in days:
            # initialized to 0 for traverling days
            dp_cost[day] = 0

        # Solve min cost by Dynamic Programming
        for day_i in range(1, 366):
            if dp_cost[day_i] == not_traveling_Day:
                # today is not traveling day
                # no extra cost
                dp_cost[day_i] = dp_cost[day_i - 1]

            else:
                # today is traveling day
                # compute optimal cost by DP
                dp_cost[day_i] = min(dp_cost[day_i - 1] + costs[_1day_pass],
                                     dp_cost[max(day_i - 7, 0)] + costs[_7day_pass],
                                     dp_cost[max(day_i - 30, 0)] + costs[_30day_pass])

        # Cost on last day of this year is the answer
        return dp_cost[365]
