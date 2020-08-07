# Time Complexity : O(n) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# Dp approach. Set dp length to the maximum day out of 365 from the days array. 
class Solution:
    def mincostTickets(self, days, costs):
        days = set(days)
        
        # Dp array, for each day, from 0 till the max day from the days array.
        dp = [0 for _ in range(max(days)+1)] 
        
        for i in range(1,len(dp)):
            # if day where we are not traveling, just copy from the previous slot.
            if i not in days:
                dp[i] = dp[i-1]
            else:
                # we need to fill in the dp array. We have 3 choices: 
                
                # 1 day pass 
                a = dp[i-1] + costs[0]
                
                # 7 days pass 
                b = 0 + costs[1] if i-7 < 0 else dp[i-7] + costs[1]
                
                # 30 days pass
                c = 0 + costs[2] if i-30 < 0 else dp[i-30] + costs[2]
                
                # choose the minimum out of all the 3.
                dp[i] = min(a,b,c)
        
        return dp[-1]
                