class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        hset = set(days)
        last_day = days[-1]
        memo = [0] * (last_day + 1)
        def recurse(i):

            if i > last_day:
                return 0

            # logic
            if i not in hset:
                return recurse(i+1)

            if memo[i] > 0: return memo[i]
            case1 = costs[0] + recurse(i+1)
            case2 = costs[1] + recurse(i+7)
            case3 = costs[2] + recurse(i+30)
            memo[i] = min(case1, case2, case3)
            return memo[i]
        return recurse(1)

    # Time complexity - O(n)
    # Space complexity - O(n)
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * (days[-1]+1)
        day = 0
        for i in range(1,len(dp)):
            if i < days[day]:  
                dp[i] = dp[i-1]
            else:
                day += 1
                dp[i] = min (costs[0] + dp[i-1], costs[1] + dp[i-7], costs[2] + dp[max(0,i-30)])
        return dp[-1]
