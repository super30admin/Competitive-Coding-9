class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        daySet = set()
        for day in days:
            daySet.add(day)
        maxDay = days[len(days) - 1] + 1
        dp =  [0 for i in range(maxDay)]
        dp[0] = 0

        for i in range(1,maxDay):
            if i not in daySet :
                dp[i] = dp[i - 1]
                continue
            dp[i] = min(dp[i - 1]+ costs[0],
            min(dp[max(0,i -7)]+costs[1],dp[max(0,i-30)]+costs[2]))
        #print(dp)
        return dp[-1]
