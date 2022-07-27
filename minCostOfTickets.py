# Approach: DP 1-D Array
# Algorithm:
# 1. Convert days list to a set - for O(1) lookup later
# 2. Create dp array with size = max(days)+1 - filled with 0s
# 3. Iterate over and fill dp array such that:
#    a. at each step, look up if we are traveling on a given day, if not, then dp[i]=dp[i-1]
#    b. If we are traveling on that day, we look at min cost of:
#           - dp[i-1] + cost[1-day ticket]
#           - dp[max(0, i-7)] + cost[7-day ticket] - we need to do `max` on 0, and i-7 because
#             if we are currently at day 6, then 6-7 will be -1 & in that case we use dp[0]
#           - dp[max(0,i-30)] + cost[30-day ticket]
# 4. Once loop is over, dp[-1] will have total minimum cost of the ticket
# TC: O(max(days)) - for loop over dp array of size max(days), plus O(n) for converting list to set
# SC: O(max(len(days), len(dp))) - if len of days is small, e.g. days=[1,1000] then len(dp) = 1001 and dominate space
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # convert list to set for O(1) look
        days = set(days)
        # dp array of len max of days plus 1 to account 0th index
        dp = [0] * (max(days)+1)
        
        for i in range(1,len(dp)):
            if i not in days:
                dp[i] = dp[i-1]
            else:
                dp[i] = min(
                            dp[i-1] + costs[0],
                            dp[max(0,i-7)] + costs[1],
                            dp[max(0,i-30)] + costs[2]
                            )
        return dp[-1]
        