# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        daysSet = set()
        for i in days:
            daysSet.add(i)
        m = days[-1]   
        dp = [0 for i in range(m+1)]
        # dp[0] = 0
        for i in range(1, len(dp)):
            if(i not in daysSet):
                dp[i] = dp[i-1]
                # continue
            else:
                            # 1 day pass
                dp[i] = min(dp[i-1] + costs[0], 
                           # 7 day pass
                           dp[max(0, i - 7)] + costs[1],
                           # 30 day pass
                           dp[max(0, i - 30)] + costs[2])
        # print(dp)
        return dp[len(dp)-1]
                
        
        
#         self.mini = float('inf')
#         dl = len(days)
#         for i in costs:
#             self.helper(days, costs, 0, [days[0], i], dl, i)
#         return self.mini
        
#     def helper(self, days, costs, ind, prevCost, dl, minsum):
#         if(ind == dl):
#             self.mini = min(self.mini, minsum)
#             return
#         if(prevCost[1] == 2):
#             prevCost[0] = days[ind]
            
#             prevCost[1] = 2
#             self.helper(days, costs, ind + 1, prevCost, dl, minsum+2)
            
#             prevCost[1] = 7
#             self.helper(days, costs, ind + 1, prevCost, dl, minsum+7)
            
#             prevCost[1] = 15
#             self.helper(days, costs, ind + 1, prevCost, dl, minsum+15)
            
#         elif(prevCost[1] == 7):
#             print(days[ind], prevCost[0])
#             if(days[ind] - 7 < prevCost[0]):
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum)
#             else:
#                 prevCost[0] = days[ind]

#                 prevCost[1] = 2
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum+2)

#                 prevCost[1] = 7
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum+7)

#                 prevCost[1] = 15
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum+15)
            
#         elif(prevCost[1] == 15):
#             if(days[ind] - 30 < prevCost[0]):
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum)
#             else:
#                 prevCost[0] = days[ind]

#                 prevCost[1] = 2
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum+2)

#                 prevCost[1] = 7
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum+7)

#                 prevCost[1] = 15
#                 self.helper(days, costs, ind + 1, prevCost, dl, minsum+15)

            
            
        