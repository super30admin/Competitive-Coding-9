"""
Runtime Complexity:
O(n) -  where 'n' is the length of the given array. We run a loop using zip function which adds the number of day pass along with cost to the date at particular index. If the number is 4, then 7 day pass would result 11. So the 
'j' increments till 11 and the cost for those is the cost of 7day pass respectively. We traverse the whole list to compute the min.
Space Complexity:
O(n) - where 'n' is the length of the list
Yes, the code worked on leetcode.
Issues while coding -No
"""

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = {}
        for i in range(len(days)-1,-1,-1):
            dp[i] = float('inf')
            for d,c in zip([1,7,30],costs):
                j = i
                while j<len(days) and days[j]< days[i]+d:
                    j+=1
                dp[i] = min(dp[i],c+dp.get(j,0))
        return dp[0]