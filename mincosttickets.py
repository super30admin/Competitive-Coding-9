# using dynamic programming
# find the maximum value in the number of days
# at every day present in the days list, we look 1 day, 7 days and 30 days max and add the corresponding costs respectively to each. We return the minimum of these values at this position.
# time complexity - O(n) -- where n is the max values in the days array.
# space complexity - O(n)
# did this solution run on leetcode? - yes

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # find the maximum number of days
        n = max(days)
        
        dp = [0] * (n+1)

        for i in range(1, n+1):
            if i not in days:
                dp[i] = dp[i-1]
                continue
        
            dp[i] = min(dp[i-1]+costs[0], dp[max(i-7,0)]+costs[1], dp[max(i-30,0)]+costs[2])
            
        
        return dp[-1]