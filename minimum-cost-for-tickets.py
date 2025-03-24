import math
# Time O(largest day)
# Space O(largest day)
class Solution:
    
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        daysSet = set(days)
        dp = [0] * (days[-1] + 1)

        for i in range(1, len(dp)):
            if i not in daysSet:
                dp[i] = dp[i-1]
            else:
                dp[i] = min(dp[i-1] + costs[0],
                            dp[max(0, i-7)] + costs[1],
                            dp[max(0, i-30)] + costs[2])
        return dp[-1]

# Brut force dfs recursion
# Time O(3^n)
# Space O(n)   
import math
class Solution:
    def __init__(self):
        self.minCost = math.inf
        self.memo = None

    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        self.memo = [[-1] * len(days) for i in range(len(costs))]
        self.dfs(days, costs, 0, 0)
        return self.minCost

    def dfs(self, days: List[int], costs: List[int], pivot, totalCost):
        if pivot == len(days):
            self.minCost = min(totalCost, self.minCost)
            return
        # 1day use
        self.dfs(days, costs, pivot + 1, totalCost + costs[0])
        # 7 day use
        nextDaytoPurchase = days[pivot] + 7
        j = 0
        for i in range(pivot + 1, len(days)):
            if days[i] >= nextDaytoPurchase:
                j = i
                break
        self.dfs(days, costs, j, totalCost + costs[1]) if j != 0 else self.dfs(days, costs, len(days), totalCost + costs[1])
        # 30 day use
        nextDaytoPurchase = days[pivot] + 30
        j = 0
        for i in range(pivot + 1, len(days)):
            if days[i] >= nextDaytoPurchase:
                j = i
                break
        self.dfs(days, costs, j, totalCost + costs[2]) if j != 0 else self.dfs(days, costs, len(days), totalCost + costs[2])

