# Time Complexity : O(D + N) N = len(days) in days list and D = travel days
# Space Complexity : O(D + N) N = len(days) in days list and D = travel days
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using DP Approach as there are repeated subporblems.
# Initialize the dp array of upto days[-1] which is last day of travel + 1
# Initialize a HashSet with the travel days
# Iterate over the dp array and check if current day is in HashSet that is if we are travelling on this day
# If not then get the previous value of index
# Else we take the minimum between i-1 and the cost for 1 day, max(0,i-7) and the cost for 7 day and max(0,i-30) and the cost for 30 days
# Return dp[-1]

class Solution:
    def mincostTickets(self, days: list[int], costs: list[int]) -> int:
        dp = [0] * (days[-1]+1)
        travelset = set(days)
        res = 0
        for i in range(1, days[-1]+1):
            if i in travelset:
                dp[i] = min(dp[i-1]+costs[0], dp[max(0,i-7)]+costs[1], dp[max(0,i-30)]+costs[2])
            else:
                dp[i] = dp[i-1]
        return dp[-1]
