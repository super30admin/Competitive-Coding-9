# Time Complexity: O(n)
# Space Complexity: O(n)
    
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n = days[-1]
        dp = [0 for _ in range(n+1)]
        
        # create set to store all days being travelled
        days_map = set()
        for day in days:
            days_map.add(day)
        
        for i in range(1,n+1):
            # if curr day is a travelling day, then calc min cost
            if(i in days_map):
                cost_1 = dp[max(i-1,0)] + costs[0]
                cost_7 = dp[max(i-7,0)] + costs[1]
                cost_30 = dp[max(i-30,0)] + costs[2]
                # curr cost will be the min of having chosen a 1d pass 1d back 
                # or 7d pass 7 days back or 30d pass 30 days back
                # if those days dont exist then chosen on 0th day
                dp[i] = min(cost_1, min(cost_7, cost_30))
            # if curr day is not a travelling day then just copy previous day's cost
            else:
                dp[i] = dp[i-1]
            
        return dp[-1]