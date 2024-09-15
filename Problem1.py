# Time Complexity:O(N) n being the number on days you travels

# Space Complexity:O(N)

# Approach:Since the minimumcost plan willbe calculated for each dy to travel we dont need to re calculate it and this will be a repeated subproblem.
# which can be solved using dynamic programming. We create a hash set of the list of days to travels so that we can have O(1) lookup time. Later,
# we calculate the cost to travel on a day if the day is the the day set as the minimum amongst daily weekly and monthly pass and store the cost of traveling
# until that day in an array. The cost will be the same as previous if we do not have to travel on that day.

# Did it run on Leetcode:Yes

from collections import defaultdict


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dayset = set(days)
        costarray = (days[-1] + 1) * [0]
        for i in range(1, len(costarray)):
            if i not in dayset:
                costarray[i] = costarray[i - 1]
            else:
                costarray[i] = min(
                    costarray[i - 1] + costs[0], costarray[max(0, i - 7)] + costs[1],
                    costarray[max(0, i - 30)] + costs[2])
        return costarray[-1]


