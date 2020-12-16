#Time Complexity : O(n) where n is the total range of days covered in the days array (including and not including the traveled days)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0 for _ in range(days[-1]+1)]

        for day in range(days[-1]+1):
            if day not in days:
                dp[day] = dp[day-1]
            #get minimum cost of taking either pass
            else:
                dp[day] = min(costs[0]+ dp[max(0, day-1)], costs[1]+dp[max(0, day-7)], costs[2]+dp[max(0, day-30)])

        return dp[-1]
