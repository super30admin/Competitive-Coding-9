Time Complexity : O(W) - maximum number of days
Space Complexity : O(W) - maximum number of days
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days or not costs:
            return 0
        dayset = set(days)
        dpArray = [0 for i in range(days[-1] + 1)] # will access last element in array + 1
      
        for i in range(1, len(dpArray)):
            if i not in dayset:
                dpArray[i] = dpArray[i-1]
            else:
                dpArray[i] = min((dpArray[i-1] + costs[0]), # 1 -day
                                (dpArray[max(i-7,0)] + costs[1]), # 7 -day
                                (dpArray[max(i-30,0)] + costs[2])) #30 - day
        return dpArray[-1]
