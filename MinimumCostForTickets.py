#Time Complexity:    O(lastDay)  |   Space Complexity:   O(lastDay)
#lastDay => number of days from 0 to lastDay
#Passed all testcases successfully on leetcode
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = {}
        def dfs(i):
            #Base Case: We completed all days
            if(i==len(days)):
                return 0
            #If we already computed that day then we can use it from our dp hashmap
            if(i in dp):
                return dp[i]
            #Initially set dp[i] value to infinity so that we can compare with the costs and update the minimum
            dp[i]=float("inf")
            #Iterate through no.of days a pass is valid and cost for them
            for d,c in zip([1,7,30],costs):
                j = i
                #To avoid going out of bound
                while(j < len(days) and days[j]<days[i]+d):
                    j+=1
                #Calculate the minimum cost in that path
                dp[i] = min(dp[i],c+dfs(j))
            return dp[i]
        return dfs(0)

