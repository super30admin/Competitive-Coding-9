class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        n= days[len(days)-1]
        dp=[0 for i in range(n+1)]
        j=0
        for i in range(1,n+1):
            if i==days[j]:
                j=j+1
                dp[i] = min([costs[0]+dp[max(0,i-1)],costs[1]+dp[max(0,i-7)],costs[2]+dp[max(0,i-30)]])
                
            else:
                dp[i]=dp[i-1]
                continue
        return dp[n]

#Time-Complexity: 0(D) where D is max 365 days
#Space-Complexity: 0(D)