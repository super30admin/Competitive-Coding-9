"""
time: O(N)
space: O(Height of Tree)
"""

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        dp = {}
        n = len(days)
        def dfs(i): #indexfor days array
            #reached end of days arr
            if i == n: 
                return 0
            if i in dp:
                return dp[i]
            #looking for a minimum
            dp[i] = float("inf")
            
            for day,cost in zip([1,7,30],costs):
                #use while loop to incr to find nextt day oob.
                j = i
                while j < n and days[j] < days[i] + day:
                    j+=1
                dp[i] = min(dp[i], cost + dfs(j))
            return dp[i]
        return dfs(0) #i is index of days arr