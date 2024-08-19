def mincostTickets(days, costs):
    dp = [0] * 366  # Initialize dp array
    
    day_set = set(days)  # Use a set for O(1) lookups
    
    for i in range(1, 366):
        if i not in day_set:
            dp[i] = dp[i - 1]  # If not a travel day, cost remains the same
        else:
            dp[i] = min(
                dp[i - 1] + costs[0],  # 1-day pass
                dp[max(0, i - 7)] + costs[1],  # 7-day pass
                dp[max(0, i - 30)] + costs[2]  # 30-day pass
            )
    
    return dp[days[-1]]  # Return the cost to cover all travel days

#time = O(D) D - maximum day
#space = O(1)