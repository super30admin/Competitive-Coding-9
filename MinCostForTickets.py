'''
    Time Complexity:
        O(365)

    Space Complexity:
        O(365)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Memoization.

        On each day, choose either of the three passes and go the travelling next day.
        Find the minimum of these three.
        Cache similar subproblems.
'''

PASS_VALIDITY = [1, 7, 30]

class Solution:
    def __init__(self):
        self.costs = []
        self.days = set()
        self.memo = {}

    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        self.days = set(days)
        self.costs = costs
        return self.find_min_cost(1)

    def find_min_cost(self, day):
        if day > 365:
            return 0

        if day in self.memo:
            return self.memo[day]

        if day not in self.days:
            return self.find_min_cost(day + 1)

        min_cost = float('inf')

        for idx, cost in enumerate(self.costs):
            next_day = day + PASS_VALIDITY[idx]

            generate_cost = cost + self.find_min_cost(next_day)
            min_cost = min(min_cost, generate_cost)

        self.memo[day] = min_cost
        return self.memo[day]
