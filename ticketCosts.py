'''
Time Complexity: O(n)
Space Complexity: O(366) -> O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Create a DP array of length 366 days, for the DP check if the current index - 7 >0 then check the value
seven days earlier, if current index - 30 >0 the check the value 30 days earlier and check min (previous Day + price
'''
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if days == None or costs == None:
            return 0

        length = 366

        daySet = set(days)

        dp = [0 for i in range(length)]

        for i in range(1, length):
            if i not in daySet:
                dp[i] = dp[i - 1]
                continue

            sevendays = costs[1]
            thirtydays = costs[2]

            if i - 7 >= 0:
                sevendays = costs[1] + dp[i - 7]

            if i - 30 >= 0:
                thirtydays = costs[2] + dp[i - 30]

            dp[i] = min(dp[i - 1] + costs[0], sevendays, thirtydays)

        return dp[i]
