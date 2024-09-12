'''
Solution:
1.  The problem can be solved using DP as there are overlapping subproblems.
Recursion Formula --
                               |cost[1-Day] + minCost(Day - 1),   |
        minCost (Day)   =   MIN|cost[7-Day] + minCost(Day - 7),   | --> If Day present in travel list
                               |cost[30-Day] + minCost(Day - 30)) |

                               [minCost(Day - 1)]                   --> If Day not present in travel list

                                Base Case --> 0 if Day <= 0

Time Complexity:    O(lastDay)  |   Space Complexity:   O(lastDay)
lastDay => number of days from 0 to lastDay

--- Passed all testcases successfully on leetcode
'''


class MinCostTickets:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:

        #   edge case check
        if (days == None or len(days) == 0):
            return 0

        #   initializations
        lastDay = days[len(days) - 1]

        minCosts = [0 for i in range(lastDay + 1)]

        #   HashSet to check whether a day is present in O(1) time; also fill the HashSet
        daySet = set()
        for i in range(len(days)):
            daySet.add(days[i])

        #   fill the DP array using above recursion formula
        for day in range(1, len(minCosts)):

            if day in daySet:
                minCosts[day] = min(minCosts[max(0, day - 1)] + costs[0],
                                    minCosts[max(0, day - 7)] + costs[1],
                                    minCosts[max(0, day - 30)] + costs[2])

            else:
                minCosts[day] = minCosts[day - 1]

        #   return last day's cost
        return minCosts[lastDay]