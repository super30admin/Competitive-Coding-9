#Time Complexity : O(N) where N is number of days
#Space Complexity :O(N) where N us number of days stored
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        d = {}
        for day in days:
            d [day] = day
        max1 = days[len(days)-1]
        dp = [0 for x in range(max1+1)]
        for i in range(1,len(dp)):
            if i not in d:
                dp[i] = dp[i-1]
            else:
                dp[i] = min((dp[i-1]+ costs[0]), (dp[max((i-7),0)] + costs[1]),(dp[max((i-30),0)] + costs[2]))
        return dp[len(dp)-1]
