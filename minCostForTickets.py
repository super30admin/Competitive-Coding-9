class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = len(days)
        
        dp = [-1 for i in range(days[n - 1] + 1)]

        validDays = set()
        for i in range(n):
            validDays.add(days[i])
        
        def helper(day):
            if day > days[n - 1]:
                return 0

            if dp[day] != -1:
                return dp[day]
            
            if day not in validDays:
                dp[day] = helper(day + 1)
            else:
                ret = float("inf")
                ret = min(ret, helper(day + 1) + costs[0])
                ret = min(ret, helper(day + 7) + costs[1])
                ret = min(ret, helper(day + 30) + costs[2])
                dp[day] = ret
            return dp[day]
        return helper(days[0])

        
