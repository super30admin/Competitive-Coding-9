"""
Build a dp[day] array up to last travel day
For each day, if it's a travel day, calculate the minimum cost by trying 1, 7, or 30-day tickets
If it’s not a travel day, carry forward the previous day’s cost
"""
"""
Time Complexity: O(365) - Traverse through all days - 365 maximum days
Space Complexity: O(n + D)  where D = max day ≤ 365
"""
class minTickets:
    def mincostTickets(self, days: list[int], costs: list[int]) -> int:
        daySet = set(days)
        last_day = days[-1]
        dp = [0] * (last_day + 1)

        for day in range(1, last_day + 1):
            if day not in daySet:
                dp[day] = dp[day - 1]
            else:
                dp[day] = min(
                    dp[max(0, day - 1)] + costs[0],
                    dp[max(0, day - 7)] + costs[1],
                    dp[max(0, day - 30)] + costs[2]
                )

        return dp[last_day]

if __name__ == "__main__":
    obj = minTickets()
    
    days = [1, 4, 6, 7, 8, 20]
    costs = [2, 7, 15]
    
    print(obj.mincostTickets(days, costs))



