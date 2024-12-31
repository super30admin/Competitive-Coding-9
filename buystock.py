"""
Tc: O(n)
Sp: O(1)
"""

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        for R in range(1, len(prices)):
            if prices[R-1]<prices[R]:
                profit+=(prices[R]-prices[R-1])
        return profit
                
        