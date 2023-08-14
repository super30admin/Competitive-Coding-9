"""
983. Minimum Cost For Tickets: You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.
"""
# Approach - 1
class Solution:
    def mincostTickets(self, days, costs) -> int:
        """
        TC: O(3^n)n=height of the tree
        SC: O(n)
        """
        def helper(days, costs, idx):
            # Base Case
            if idx >= len(days):
                return 0
            
            
            # Logic
            # case_1 : one day pass
            case_1 = costs[0] + helper(days, costs, idx + 1)
            
            # case_2: 7 days pass
            i = idx
            while i < len(days):
                if days[i] >= days[idx] + 7: break
                else: i += 1       
            case_2 = costs[1] + helper(days, costs, i)
            
            # case_3 : 30 days pass
            i = idx
            while i < len(days):
                if days[i] >= days[idx] + 30:break
                else: i+=1   
            case_3 = costs[2] + helper(days, costs, i)
            
            return min(case_1, min(case_2, case_3))
        
        return helper(days, costs, 0)

# Approach - 2

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        """
        Using memoization
        TC: Same as above
        SC: Same
        """
        dp = [-1 for _ in range(len(days) + 1)]
        
        def helper(days, costs, idx):
            nonlocal dp
            
            # Base Case
            if idx >= len(days):
                return 0
            
            if dp[idx] != -1:
                return dp[idx]
            
            
            # Logic
            # case_1 : one day pass
            case_1 = costs[0] + helper(days, costs, idx + 1)
            
            # case_2: 7 days pass
            i = idx
            while i < len(days):
                if days[i] >= days[idx] + 7: break
                else: i += 1       
            case_2 = costs[1] + helper(days, costs, i)
            
            # case_3 : 30 days pass
            i = idx
            while i < len(days):
                if days[i] >= days[idx] + 30:break
                else: i+=1   
            case_3 = costs[2] + helper(days, costs, i)
            
            dp[idx] = min(case_1, min(case_2, case_3))
            
            return dp[idx]
        
        return helper(days, costs, 0)
        
# Approach - 3

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        """
        Bottom up tabulation dp
        TC:O(N)N= no of days
        SC: O(N)
        """
        dp = [float("inf") for _ in range(len(days) + 1)]
        dp[len(days)] = 0
        
        #Bottom up approach
        for j in range(len(days) - 1, -1, -1):
            # case_1 : one day pass
            case_1 = costs[0] + dp[j+1]
            
            # case_2: 7 days pass
            i = j
            while i < len(days):
                if days[i] >= days[j] + 7: break
                else: i += 1       
            case_2 = costs[1] + dp[i]
            
            # case_3 : 30 days pass
            i = j
            while i < len(days):
                if days[i] >= days[j] + 30:break
                else: i+=1   
            case_3 = costs[2] + dp[i]
            
            dp[j] = min(case_1, min(case_2, case_3))
            
        return dp[0]
        
        
        

        