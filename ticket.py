#as taught in class using DP to solve this problem
#Time complexity O(n)
#Space Complexity: O(n)
def mincostTickets(self, days: List[int], costs: List[int]) -> int:
    set = list()
    for day in days:
        set.append(day)
    maxi = days[-1]
    dp = [0 for i in range(maxi+1)]
    print(dp)
    for i in range(1,len(dp)):
        if i not in set:
            dp[i] = dp[i-1]
        else:
            dp[i] = min(dp[i-1]+costs[0], 
                       min(
                           dp[max(i-7,0)]+costs[1] ,
                           dp[max(i-30,0)]+costs[2]
                       
                        )
                       
                       )
    return dp[len(dp)-1]