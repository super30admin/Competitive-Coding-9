# Time Complexity: O(n), n is max of days
# Space Complexity: O(n), n is max of days
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        ls=set(days)
        dp=[0]*(max(days)+1)
        for i in range(1,len(dp)):
            if i not in ls:
                dp[i]=dp[i-1]
                continue
            dp[i]=min(costs[0]+dp[max(0,i-1)],costs[1]+dp[max(0,i-7)],costs[2]+dp[max(0,i-30)])
        return dp[len(dp)-1]
    # def mincostTickets(self, days: List[int], costs: List[int]) -> int:
    #     if days==None or len(days)==None: return days
    #     self.result=[]
    #     self.mini=float('inf')
    #     self.helper(days,0,costs,0,[])
    #     return self.mini
    # def helper(self, days: List[int],i:int, costs: List[int],cost:int,path:List[int]):
    #     #base case
    #     if i>=len(days):
    #         # print(path,cost)
    #         self.mini=min(cost,self.mini)
    #         return
    #     #logic
    #     path.append(days[i])
    #     self.helper(days,i+1,costs,cost+costs[0],path.copy())
    #     k=i
    #     while k<len(days) and days[k]<7+days[i]:
    #         k+=1
    #     self.helper(days,k,costs,cost+costs[1],path.copy())
    #     while k<len(days) and days[k]<30+days[i]:
    #         k+=1
    #     self.helper(days,k,costs,cost+costs[2],path.copy())