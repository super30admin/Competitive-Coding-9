#Time: O(n): Time to traverse the array
#Space: O(n): space for the 1d dp array
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        dp_list = [0]*(days[-1]+1)
        set_days = set(days)
        
        for i in range(1,days[-1]+1):
            if i in set_days:
                dp_list[i] = min(dp_list[max(0,i-1)]+costs[0],dp_list[max(0,i-7)]+costs[1], dp_list[max(0,i-30)]+costs[2])
            else:
                dp_list[i] = dp_list[i-1]
        return dp_list[-1]