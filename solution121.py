#Time Complexity:O(1)
#Space Complexity:O(1)
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if len(days)==0:
            return 0
        dp=[0 for i in range(366)]                                          #create a dp array of size 365
        d=min(costs)                                                        #start with d holding the minimum possible cost
        for i in range(1,len(dp)):
            if i in days:                                                   #if travelling on any day 
                d=dp[i-1]+min(costs)                                        #find the minimum cost amongst day, month or weekly passess
                if i-7>=0:
                    w=dp[i-7]+costs[1]
                else:
                    w=d
                if i-30>=0:
                    m=dp[i-30]+costs[2]
                else:
                    m=min([d,w])
                dp[i]=min([d,w,m])                                          #add min value of pass to the dp array
            else:                                                           #if not travelling on any day
                if i%30==0:                                                 # check if monthly pass is less expensive for every 30 days than current
                    dp[i]=min([dp[i-1],costs[2]*(i//30)])
                elif i%7==0:                                                # check if weekly pass is less expensive for every 7 days than current
                    dp[i]=min([dp[i-1],costs[1]*(i//7)])
                else:
                    dp[i]=dp[i-1]                                           #else update cost to be same as previous day
        return dp[-1]                                                       #return the cost on the 365th day