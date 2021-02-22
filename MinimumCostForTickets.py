# Time Complexity : O(N) N is last day
# Space Complexity : O(N) N is last day
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Using DP Approach as there are repeated subporblems.
# Initialize the dp array of upto lastday + 1
# Initialize a HashSet with the travel days
# Iterate over the dp array and check if current day is in HashSet that is if we are travelling on this day
# If not then get the previos value of index
# Else we take the minimum between i-1 and the cost for 1 day, max(i-7,0) and costs for 7 day and max(i-30,0) and costs for 30 days


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        last_day = days[-1]
        dp = [0] * (last_day + 1)
        days = set(days)
        for i in range(1, len(dp)):
            if i not in days:
                dp[i] = dp[i - 1]
            else:
                dp[i] = min(costs[2] + dp[max(i - 30, 0)],
                            costs[1] + dp[max(i - 7, 0)], costs[0] + dp[i - 1])
        return dp[-1]