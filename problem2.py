# problem 2 

# https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution:
    def helper(self,dp_arr,costs,last_day,curr_day):
        if curr_day > last_day[-1]:
            return 0 
        if curr_day not in last_day:
            return self.helper(dp_arr,costs,last_day,curr_day+1)
        if dp_arr[curr_day] != -1:
            return dp_arr[curr_day]
        day_1 = costs[0] + self.helper(dp_arr,costs,last_day,curr_day+1)
        day_7 = costs[1] + self.helper(dp_arr,costs,last_day,curr_day+7)
        day_30 = costs[2] + self.helper(dp_arr,costs,last_day,curr_day+30)
        dp_arr[curr_day] = min([day_1,day_7,day_30])
        return dp_arr[curr_day]


    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp_arr = [-1]*(days[-1]+1)
        return self.helper(dp_arr,costs,days,1)