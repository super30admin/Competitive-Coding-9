# Time Complexity : O(3 ^ D) where D is last day of travel within 365 days
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No


class Solution:
    def __init__(self):
        self.minCost = float('inf')
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        self.finder(days, costs, 0, 0, 0)
        return self.minCost
        
    def finder(self, days, costs, d, spent, validity):
        #base
        if d == len(days):
            self.minCost = min(spent, self.minCost)
            return
        
        #logic
        if days[d] > validity:
            self.finder(days, costs, d + 1, spent + costs[0], validity + 1)
            self.finder(days, costs, d + 1, spent + costs[1], validity + 7)
            self.finder(days, costs, d + 1, spent + costs[2], validity + 15)
        else:
            self.finder(days, costs, d + 1, spent, validity)