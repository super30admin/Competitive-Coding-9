days = [1,4,6,7,8,20,25]
costs = [2,7,15]
# Time O(N)
# Space O(N)
hset = set(days)
dp = [0 for i in range(days[-1] + 1)]
print(dp)
len = len(dp)
print("Len", len)
for i in range(len):
    if i not in hset:
        dp[i] = dp[i-1]
    else:
        # Find min
        dp[i] = dp[i-1] + costs[0]
        dp[i] = min(dp[i], dp[max(i-7, 0)] + costs[1])
        dp[i] = min(dp[i], dp[max(i-30, 0)] + costs[2])
print(dp)