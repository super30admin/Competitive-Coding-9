#Time Complexity: O(days)
#Space Complexity: O(days)
def mincostTickets(self, days: List[int], costs: List[int]) -> int:
    if not days:
        return 0
    n = len(days)
    max_val = days[n - 1]
    dp = [0] * (max_val + 1)
    days_index = 0
    for i in range(1, max_val + 1):
        if i not in days:
            dp[i] = dp[i - 1]
        else:
            pass_1 = costs[0] + dp[i - 1]
            if i >= 7:
                pass_7 = costs[1] + dp[i - 7]
            else:
                pass_7 = costs[1]
            if i >= 30:
                pass_30 = costs[2] + dp[i - 30]
            else:
                pass_30 = costs[2]
            dp[i] = min(pass_1, min(pass_7, pass_30))
    return dp[max_val]