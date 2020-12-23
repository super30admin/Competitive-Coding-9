"""
Time Complexity : O(maximum number of days)
Space Complexity : O(maximum number of days)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
At every point of day in array days, the user has the opportunity to buy 1 day, 7 day or 30 day pass. So,
here, we are doing bottom up approach basically. At every point, we are calculating what would be the minimum 
cost had the user bought the pass 1 day ago, 7 days ago or 30 days ago.
"""


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days or not costs:
            return 0
        dayset = set(days)
        dparray = [0 for i in range(days[-1]+1)]
        l = len(dparray)
        for i in range(1, l):
            if i not in dayset:
                dparray[i] = dparray[i-1]
            else:
                dparray[i] = min((dparray[i-1]+costs[0]), (dparray[max(i-7, 0)
                                                                   ]+costs[1]), (dparray[max(i-30, 0)]+costs[2]))
        return dparray[-1]
