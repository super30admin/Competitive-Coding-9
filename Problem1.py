# Problem 1 : Minimum Cost For Tickets
# Time Complexity : O(3^N) where N is the last working day
# Space Complexity : O(3^N) where N is the last working day
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # define hashSet for the days list
        hashSet = set(days)
        # get the last day for travelling
        lastDay = max(days)
        # define dp array with length as (lastDay+1) with 0
        dp = [0] * (lastDay+1)

        # loop from 1 to lastDay+1
        for i in range(1, lastDay + 1):
            # check if the day is in hash set
            if i not in hashSet:
                # if it is not a travel day then just carry forward the cost
                # assign the previous value of dp to dp at ith position
                dp[i] = dp[i-1]
            # else means it is travelling day
            else:
                # calculate the minimum between the cost for 1 day pass, 7 days pass and 30 days pass
                dp[i] = min(
                    dp[max(0, i-1)] + costs[0], # 1 day pass ie value of (i-1) position in dp plus the cost of 1 day pass
                    dp[max(0, i-7)] + costs[1], # 7 days pass ie value of (i-7) position in dp plus the cost of 7 days pass
                    dp[max(0, i-30)] + costs[2] # 30 days pass ie value of (i-30) position in dp plus the cost of 30 days pass
                    )
        # return the value of lastDay position in dp
        return dp[lastDay]
