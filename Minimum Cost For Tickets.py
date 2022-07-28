# TC : O(last_day)
# SC : O([0,last_day])
class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        last_day = days[-1]
        dp = [0] * (last_day + 1) 
        # convert day to set for fast look up later - space O(len(days))
        days = set(days) 
        for d in range(1, last_day + 1):
            # to make sure we have pass, we either buy a 1-d pass today, a 7-d pass 6 days ago, or a 30-d pass 29 days ago
            if d in days:
                dp[d] = min(costs[2] + dp[max(d - 30, 0)], costs[1] + dp[max(d - 7, 0)], costs[0] + dp[d - 1])
            
            # Don't buy pass on day not in days
            else: 
                dp[d] = dp[d - 1]
        print(dp)
        return dp[-1]