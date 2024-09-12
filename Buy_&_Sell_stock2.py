# Time - O(N)
# Space - O(1)
# one pass and buying and selling N times if price is greater than previous buy 

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        if not prices:
            return 0
        
        profit = 0
        buy = prices[0]
        
        for i in range(1,len(prices)):
            if prices[i] > buy:
                profit += prices[i] - buy
            
            buy = prices[i]
            
        return profit 
