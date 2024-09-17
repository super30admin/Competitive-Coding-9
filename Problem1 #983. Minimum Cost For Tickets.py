# Time Complexity:    O(lastDay)    # lastDay => number of days from 0 to lastDay
# Space Complexity:   O(lastDay)

class MinCostTickets:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # base
        if days == None or len(days) == 0:
            return 0

        # logic
        lastDay = days[len(days) - 1]
        minCosts = [0 for i in range(lastDay + 1)]

        daySet = set()
        for i in range(len(days)):
            daySet.add(days[i])

        for day in range(1, len(minCosts)):
            if day in daySet:
                minCosts[day] = min(minCosts[max(0, day - 1)] + costs[0], minCosts[max(0, day - 7)] + costs[1], minCosts[max(0, day - 30)] + costs[2])
            else:
                minCosts[day] = minCosts[day - 1]

        return minCosts[lastDay]
