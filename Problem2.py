'''

Time Complexity : O(n)
Space Complexity : O(max(n))
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

I will build a memoization reference array list and start computing the minimum costs from the end. 

'''


class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        high = days[-1]
        low = days[0]
        dayset = set(days)

        ref = [0 for _ in range(high+1)]

        one = 0
        seven = 0
        thirty = 0

        for i in range(high,0,-1):
            if i in dayset:

                if i + 1 > high:
                    one = 0 + costs[0]

                elif i + 1 <= high:
                    one = ref[i+1] + costs[0]

                if i + 7 > high:
                    seven = 0 + costs[1]

                elif i + 7 <= high:
                    seven = ref[i+7] + costs[1]

                if i + 30 > high:
                    thirty = 0 + costs[2]

                elif i + 30 <= high:
                    thirty = ref[i+30] + costs[2]

                ref[i] = min(one,seven,thirty)

            else:
                ref[i] = ref[i+1]

        return ref[1]
