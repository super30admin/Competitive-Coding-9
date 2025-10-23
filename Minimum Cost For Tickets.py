'''
Time - O(max(days))
Space - O(max(days))
'''
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        max_day = days[-1] # max-day index of travelling
        dp_costs = [0]*(max_day+1) # len 0 -> max_day

        day_set = set(days) 

        for i in range(1,len(dp_costs)):
            if i in day_set:
                # travelling day
                cost_1day_ticket = dp_costs[i-1] + costs[0] 
                cost_7day_ticket = dp_costs[max(i-7,0)] + costs[1] 
                cost_30day_ticket = dp_costs[max(i-30,0)] + costs[2] 
                dp_costs[i] = min(cost_1day_ticket,cost_7day_ticket,cost_30day_ticket)
            else:
                # no travelling day
                dp_costs[i] = dp_costs[i-1] # carry forward the costs
        
        return dp_costs[-1]


