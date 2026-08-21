#Problem 2: https://leetcode.com/problems/minimum-cost-for-tickets/description/
# Time Complexity: O(lastDay),We only compute helper for each day from 1 to 365 once, since memo stores results after first calculation. Each call does constant work.
# Space Complexity: O(lastDay),The memo array holds 366 slots and the recursion stack can go as deep as 365 calls in the worst case.
# Approach:
# We first put all travel days in a set so we can check in O(1) time if a day needs a ticket.
# Then we walk through days from 1 to 365 using recursion.
# On a travel day we try all three options, buying a 1 day pass, a 7 day pass or a 30 day pass and jump ahead to the day right after each pass ends. We take whichever option gives the smallest total cost.
# On a non travel day we simply move to the next day without spending anything.
# We cache every result in memo so we never recompute the cost for the same day twice.

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        self.costs = costs
        # storing costs so helper can access them without passing as a parameter every time

        self.dayset = set(days)
        # converting days list into a set so checking if a day is a travel day takes O(1) instead of O(n)

        self.memo = [None] * 366
        # creating a memo array with 366 slots, giving us valid indices from 0 to 365 to match the day range 1 to 365

        return self.helper(1)
        # starting the recursion from day 1, since travel days begin at day 1

    def helper(self, i):
        if i > 365:
            return 0
            # base case, once we go past the last possible day there is nothing left to pay for, so cost is 0

        if self.memo[i] is not None:
            return self.memo[i]
            # if we already solved this day before, reuse the stored answer instead of recomputing it

        if i in self.dayset:
            # this means day i is a day we actually need to travel, so we must buy some pass that covers it

            answer = min(self.helper(i + 1) + self.costs[0],
                         # option 1, buy a 1 day pass covering just day i, then solve for the very next day

                         self.helper(i + 7) + self.costs[1],
                         # option 2, buy a 7 day pass covering day i through i+6, so the next day needing a decision is i+7

                         self.helper(i + 30) + self.costs[2])
                         # option 3, buy a 30 day pass covering day i through i+29, so the next day needing a decision is i+30

        else:
            answer = self.helper(i + 1)
            # if day i is not a travel day, we do not need to spend anything, we just move on to the next day

        self.memo[i] = answer
        # storing this day's answer in memo so future calls to helper(i) return instantly

        return answer
        # returning the minimum cost starting from day i