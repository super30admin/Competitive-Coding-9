class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        # at each day, check min of the price by taking one day pass,7 day pass and 30 day pass
        # if that day is not in the days array just copy the prev day's value
        # TC-O(N),SC-O(N)
        s = set(days)
        m = days[len(days)-1]
        dp = [0 for i in range(m+1)]
        le = len(dp)
        for i in range(1,le):
            prev = dp[i-1]
            if i not in s:
                dp[i]=prev
            else:
                # find min
                dp[i]=prev+costs[0]
                dp[i]=min(dp[i],dp[max(i-7,0)]+costs[1])
                dp[i]=min(dp[i],dp[max(0,i-30)]+costs[2])
        return dp[-1]


