# 983. Minimum Cost For Tickets
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        mincost = [0 for _ in range(0,days[-1]+1)]

        def helper(days,costs):
            travel_days = set(days)
            nonlocal mincost
            for i in range(1, len(mincost)):
                if i not in travel_days:
                    mincost[i] = mincost[i-1]
                else:
                    one_day = costs[0] + mincost[i-1]
                    seven_day = costs[1] + mincost[max(0,i-7)]
                    thirty_day = costs[2] + mincost[max(0,i-30)]
                    mincost[i] = min(one_day,seven_day,thirty_day)

        helper(days,costs)
        return mincost[-1]
            

            


        
        