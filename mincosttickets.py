# Time complexity: O(N)
# Space complexity: O(N)

def mincostTickets(days, costs):
    travel_days = set(days)
    last_day = days[-1]
    dp = [0] * (last_day + 1)

    for i in range(1, last_day + 1):
        if i not in travel_days:
            dp[i] = dp[i - 1]
        else:
            dp[i] = min(
                dp[max(0, i - 1)] + costs[0],
                dp[max(0, i - 7)] + costs[1],
                dp[max(0, i - 30)] + costs[2]
            )

    return dp[last_day]
