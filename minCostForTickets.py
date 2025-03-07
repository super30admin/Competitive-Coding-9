class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # T: O(3 ** n), S: O(n)
        n = len(days)

        def dfs(i):
            if i == n:
                return 0

            res = costs[0] + dfs(i + 1)
            j = i
            while j < n and days[j] < days[i] + 7:
                j += 1
            res = min(res, costs[1] + dfs(j))

            j = i
            while j < n and days[j] < days[i] + 30:
                j += 1
            res = min(res, costs[2] + dfs(j))

            return res

        return dfs(0)
