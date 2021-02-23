# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        if not prices:
            return maxProfit
        
        #one pass prices
        curr = prices[0]
        
        for i in range(len(prices)):
            if prices[i] < curr:
                curr = prices[i]
            if prices[i] > curr:
                maxProfit += prices[i] - curr
                curr = prices[i]
                
        return maxProfit