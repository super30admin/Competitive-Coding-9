"""
TC:O(N) where N is the no. of elements in the list of days given 
SC:O(1)
"""
#This is a DP problem of exploring all paths
#minCost() calculates the min cost of tickets from all paths
#nd()() function calculates the no. of days after which the day pass gets invalid
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        self.dp = [0] * len(days)
        self.days = days
        self.costs = costs
        return self.minCost(0)
        
    def nd(self, day_indx, duration):
        if duration == 1:
            return day_indx + 1
        
        indx = day_indx
        lastday = self.days[indx] + duration - 1
        
        while indx < len(self.days) and self.days[indx] <= lastday:
            indx += 1
            
        return indx
    
    def minCost(self, index):
        #base case
        if index == len(self.days):
            return 0
        
        if self.dp[index] != 0:
            return self.dp[index]
        
        #logic
        
        self.dp[index] = min(self.costs[0] + self.minCost(self.nd(index, 1)), self.costs[1] + self.minCost(self.nd(index, 7)), self.costs[2] + self.minCost(self.nd(index, 30)))
        
        return self.dp[index]
        