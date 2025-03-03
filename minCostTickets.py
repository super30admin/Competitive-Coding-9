class Solution:
    # TC : O(1)
    # SC : O(1) as we can consider the number 366 as constant 
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if days is None:
            return 0
        dp = [0]*366
        for day in range(1, 366):
            if day not in days:
                # considering previous day costs
                # print(day)
                dp[day] = dp[day - 1]
            elif day > days[-1]:
                # stoping the traversal if we have encountered last day in days array
                return dp[day-1]
            else:
                dp[day] = min(dp[day - 1] + costs[0],
                              dp[max(0, day - 7)] + costs[1],
                              dp[max(0, day - 30)] + costs[2])
        
        return dp[-1]