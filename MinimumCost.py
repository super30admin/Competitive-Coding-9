# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use recursion + memoization.
# At each index, we try buying 3 types of passes:
# 1-day → move to i+1
# 7-day → skip all days within next 7 days
# 30-day → skip all days within next 30 days
# Use two pointers (j, k) to find the next index not covered by 7-day and 30-day passes.
# Store results in dp (memo) to avoid recomputation.
# Return the minimum cost among all choices.



class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:

        def helper(i,dp):
            if i >= n:
                return 0
            if i in dp:
                return dp[i]
            one = costs[0] + helper(i + 1,dp)
            j = i
            while j < n and days[j] < days[i] + 7:
                j += 1
            seven = costs[1] + helper(j,dp)
            k = i
            while k < n and days[k] < days[i] + 30:
                k += 1
            thirty = costs[2] + helper(k,dp)
            dp[i] = min(one,seven,thirty)
            return dp[i]
        n = len(days)
        dp = {}
        return helper(0,dp)