# TC : O(N)
# SC : O(N)

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        memo = [None] * len(days)
        durations = [1, 7, 30]

        def helper(idx):
            if idx >= len(days):
                return 0
            if memo[idx] != None:
                return memo[idx]
            ans = math.inf
            j = idx
            for k in range(3):
                while j < len(days) and days[j] < days[idx] + durations[k]:
                    j += 1
                ans = min(ans, helper(j) + costs[k])
            memo[idx] = ans
            return ans

        return helper(0)