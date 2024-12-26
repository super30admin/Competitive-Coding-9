    # Calculates the minimum cost of travel tickets given a list of travel days 
    # and the costs of 1-day, 7-day, and 30-day passes.

    # Args:
    # days: A list of integers representing the days of the month when travel is needed.
    # costs: A list of three integers representing the costs of 1-day, 7-day, and 30-day passes respectively.

    # Returns:
    # The minimum cost of travel tickets to cover all travel days.

    # Time Complexity: O(N), where N is the last travel day.
    # Space Complexity: O(N) in the worst case.

def mincostTickets(days, costs):
	days_set = set(days)
	memo = {}

	def dp(day):
		if day > days[-1]:
			return 0
		if day in memo:
			return memo[day]
		if day in days_set:
			cost1 = dp(day + 1) + costs(0)
			cost7 = dp(day + 7) + costs(1) if day + 7 <= days[-1] else float('inf')
			cost30 = dp(day + 30) + costs(2) if day + 30 <= days[-1] else float('inf')
			memo[day] = min(cost1, cost7, cost30)
		else:
			memo(day) = dp(day + 1)

		return memo(day)

	return dp(days[0])