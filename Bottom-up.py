class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        # bottom up dp calculating backward 
        # tc : o(lastday), sc : O(lastday)

        n = len(days)
        last_day = days[-1]
        days_set = set(days) # to look up in set takes O(1) where as list is O(n) so changing to set 
        dp = [0]*(last_day+31) # to avpid out of boounds i am taking dp from the first day to the last day travel + amonth as we add 30 days pass as well


        for day in range(last_day, days[0]-1, -1): # iterating from backwards from the last day to the firt traveling day 
            if day not in days_set:
                dp[day] = dp[day+1] # if this day we are nto travelling its cost is same as the next travel day since iteratign backwards
            else:
                dp[day] = min(
                    costs[0] + dp[day+1],
                    costs[1] + dp[day+7],
                    costs[2] + dp[day+30] # to avoid the out of bounds intially took the dp array till last_day + 31
                )
        
        return dp[days[0]] # return the cost of the first traveling day which covers all the days we travel in that year 


