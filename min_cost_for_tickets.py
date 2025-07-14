#Time Complexity: O(N)
#Space Complexity: O(1) # max 365 days are stored
class Solution(object):
    def mincostTickets(self, days, costs):
        day_set = set(days)
        durations = [1, 7, 30]
        memo = {}

        def dp(day):
            if day > 365:
                return 0
            if day in memo:
                return memo[day]
            if day not in day_set:
                memo[day] = dp(day + 1)
                return memo[day]

            # Try all 3 types of passes
            memo[day] = min(
                costs[i] + dp(day + durations[i])
                for i in range(3)
            )
            return memo[day]

        return dp(1)