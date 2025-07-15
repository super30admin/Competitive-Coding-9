# Time Complexity :O(30*n) ~ O(n)
# Spacae Complexity: O(n) #number of days
#Approach: brute force wouldbe  try all variations but when you draw tree you will understand there are multiple repeated sub problems so we can make use of dp
# dp[i] says min cost untill ith day for 7 day and 30 days you need to back 7 and 30 days and add those costs to cost of 7 day adn 30 day pass make sure if goses beyond bounds
# it will 0
# Other approach is to take into count of max days

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp =[0 for i in range(len(days))]
        dp[0]=min(costs)
        for i in range(1,len(days)):
            d7,d30=float('inf'),float('inf')
            
            for j in range(i,i-8,-1):
                if j>=0:
                    if days[i]-days[j]>=7:
                        # print(days[j])
                        d7=dp[j]

                        break
                else:break
    

            #30
            for j in range(i,i-31,-1):
                if j>=0:
                    if days[i]-days[j]>=30:
                        d30=dp[j]

                        break
                else:break
                
            if d7==float('inf'):d7=0
            if d30==float('inf'):d30=0
            # print(d7,days[i],"d7")
            dp[i]=min(costs[0]+dp[i-1],d7+costs[1],d30+costs[2])
        # print(dp)
        return dp[-1]



#####################################

# Approach 2

#####################################




class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * (days[-1] + 1)

        for d in days:
            dp[d - 1] = 1

        for i in reversed(range(days[-1])):
            if dp[i] == 1:
                dp[i] = min(
                    costs[0] + dp[min(days[-1], i + 1)],
                    costs[1] + dp[min(days[-1], i + 7)],
                    costs[2] + dp[min(days[-1], i + 30)],
                )
            else:
                dp[i] = dp[i + 1]

        return dp[0]
