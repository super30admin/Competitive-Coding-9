# The time complexity is: O(n) using memoization
#The space is O(n) as well using memo cache and recursion depth stack

# The intuition is to do recursive exhaustive solution to calculate the min cost for each element for the 1, 7 and 30 days. And then return the minimum of the result that we get.

class Solution:
    def minCostTicketsTopDown(self, days: List[int], costs: List[int]) -> int:

        self.memo = {}

        def helper(i):
            if i == len(days):
                return 0
            if i in self.memo:
                return self.memo[i]
            self.memo[i] = float("inf")
            for cost, duration in zip(costs, [1, 7, 30]):
                j = i
                while j < len(days) and days[j] < days[i] + duration:
                    j += 1
                self.memo[i] = min(self.memo[i], cost + helper(j))

            return self.memo[i]

        return helper(0)

    # The time and space is same. Intuition is also same using the for loop to calculate the min result as long as the j index is in bounds. 
    def minCostTicketsBottomUP(self, days: List[int], costs: List[int]) -> int:

        dp = [0] * (len(days) + 1)
        for i in range(len(days) - 1, -1, -1):
            res = float("inf")
            for cost, duration in zip(costs, [1, 7, 30]):
                j = i
                while j < len(days) and days[j] < days[i] + duration:
                    j += 1
                    res = min(res, cost + dp[j])
                dp[i] = res
        return dp[0]
