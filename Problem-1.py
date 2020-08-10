# Time Complexity :O(n)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # sum of profit
        prof = 0
        # start from second place and loop till end
        for i in range(1,len(prices)):
            # if pos > pos-1 add the difference to the prof
            if prices[i] > prices[i-1]:
                prof += prices[i]- prices[i-1]
        # return prof
        return prof