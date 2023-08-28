class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:

        #Method 1 - Brute Force - Explore all 3 ways at each point and get minimum. -> TC 3^n*n
        # def helper(i,valid):
        #     #base
        #     if i==len(days):
        #         return 0
        #     if days[i]<valid:
        #         return helper(i+1,valid)

        #     #logic
        #     one_day=costs[0]+helper(i+1,days[i]+1)
        #     seven_day=costs[1]+helper(i+1,days[i]+7)
        #     month_day=costs[2]+helper(i+1,days[i]+30)

        #     return min(one_day,seven_day,month_day)
        
        # return helper(0,0)

        #Method 2 - DP - Draw the tree-> repeating sub problems. - O(n) TC and SC
        dp=[0 for _ in range(days[-1]+1)]

        dayset=set()
        for day in days:
            dayset.add(day)

        for i in range(1,len(dp)):
            if i not in dayset: #if not in days, array no travel, so value for this i doesn;t chnage
                dp[i]=dp[i-1]

            else: 
                dp[i]=min(costs[0]+dp[i-1], #if you buy 1-day, then it's ticket cost +so far total
                        costs[1]+(dp[i-7] if i>=7 else 0),#if you buy 1-day, then it's ticket cost + total so far on i-7th day
                        costs[2]+(dp[i-30] if i>=30 else 0)) #if you buy 1-day, then it's ticket cost + total so far on i-30th day
        return dp[-1]