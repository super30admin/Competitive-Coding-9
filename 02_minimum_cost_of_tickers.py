# Time Complexity : O(n) where n is 365 days
# Space Complexity : O(n) where n is 365 days
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
Approach:

create a dp array of size = largest day in days array + 1
keep all values to infinity expect dp[0] = 0

when we loop over our DP and if i is present in the days array then
if 7 days and 30 days back does not exists:
    dp will contain minimum (previous day + day1, 0th day + day7, 0th day + day30)
else if 7 days exists:
    dp will conatin minimum of (previous day + day1, i-7th day + day7, 0th day + day30)
else if all 3 exits:
    dp will conatin minimum of (previous day + day1, i-7th day + day7, i-30th day + day30)
'''


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        dp = [float('inf') for x in range(days[-1]+1)]
        
        dp[0] = 0
        
        for i in range(1, days[-1] + 1):
            if i in days:
                if i-1 >= 0 and i-7 >= 0 and i-30>= 0:
                    dp[i] = min((dp[i-1] + costs[0]), min((dp[i-7] + costs[1]), (dp[i-30] + costs[2])))
                elif i-1 >= 0 and i-7 >= 0:
                    dp[i] = min((dp[i-1] + costs[0]), min((dp[i-7] + costs[1]), (dp[0] + costs[2])))
                elif i-1 >= 0:
                    dp[i] = min((dp[i-1] + costs[0]), min((dp[0] + costs[1]), (dp[0] + costs[2])))
            else: 
                dp[i] = dp[i-1]
                
        # for i in range(len(dp)):
        #     print(f"for {i} dp is {dp[i]}")

        return dp[-1]