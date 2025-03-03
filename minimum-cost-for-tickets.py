# tc O(n), sc O(n).
dp = [0] * (len(days)+1)
left7 = left30 = 0

for right in range(1, len(days)+1):
    cost1 = costs[0] + dp[right-1]

    while days[right-1] - days[left7] >= 7:
        left7 += 1
    while days[right-1] - days[left30] >= 30:
        left30 += 1
    
    cost7 = costs[1] + dp[left7]
    cost30 = costs[2] + dp[left30]

    dp[right] = min(cost1, cost7, cost30)

return dp[-1]