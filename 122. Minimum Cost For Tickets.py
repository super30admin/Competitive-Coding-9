class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        travel = [0] * (days[-1] + 1)

        n = len(travel)
        print(n)

        for i in range(1, n):
            if i not in days:
                travel[i] = travel[i - 1]

            else:
                travel[i] = min(travel[i - 1] + costs[0],
                                min(travel[max(i - 7, 0)] + costs[1],
                                    travel[max(i - 30, 0)] + costs[2]))

        return travel[-1]

# Dynamic Programming
# Time Complexity: O(m + n)
# Space Complexity: O(n). Size of the DP array
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
