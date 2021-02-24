class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:

        days_set = set(days)

        dp = [0] * (days[len(days) - 1] + 1)


        for day in range(1, len(dp)):

            if day not in days_set:
                dp[day] = dp[day - 1]

            else:

                one = costs[0] + dp[day - 1]
                seven = costs[1] + dp[max(d-7, 0)]
                thirty = costs[2] + dp[max(d-30, 0)]

                dp[day] = min(one, seven, thirty)

        return dp[-1]