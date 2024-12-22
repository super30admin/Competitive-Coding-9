class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # The maximum days 365
        max_day = 365
        
        # quick visit for specific day.
        travel_days = set(days)
        
        # Create a list (dynamic programming array) to store the minimum cost up to each day.
        # memo[i] will represent the minimum cost to travel,
        # intialise 0 we start with nocost on the day 0.
        memo = [0] * (max_day + 1)
        
        # Loop through each day from 1 to 365 to calculate the minimum cost
        for i in range(1, max_day + 1):
            # If the current day is not in the travel days, no travel is needed.
            # The cost for this day is the same as the previous day's cost.
            if i not in travel_days:
                memo[i] = memo[i - 1]
            else:
                # If it is a travel day, calculate the minimum cost using the three ticket options:
        
                # Option 1: Buy a 1-day pass
                # Cost for the current day = previous day's cost + cost of a 1-day ticket.
                cost_1_day = memo[i - 1] + costs[0]
                
                # Option 2: Buy a 7-day pass
                # check up to 7 days earlier. If i < 7, assume the cost before day 0 is 0.
                cost_7_day = memo[max(0, i - 7)] + costs[1]
                
                # Option 3: Buy a 30-day pass
                # check up to 30 days earlier. If i < 30, assume the cost before day 0 is 0.
                cost_30_day = memo[max(0, i - 30)] + costs[2]
                
                # Choose the minimum cost among the three options for this day.
                memo[i] = min(cost_1_day, cost_7_day, cost_30_day)
        
        # At the end of the loop, memo[max_day] contains the total minimum cost to cover all the travel days.
        return memo[max_day]
