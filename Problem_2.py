# https://leetcode.com/problems/minimum-cost-for-tickets/description/
# class Solution:
#     def mincostTickets(self, days, costs):
#         minimumCost = self.helper(0, days, costs, 0)
#         return minimumCost

#     def helper(self, index, days, costs, lastDayOfPass):
#         if index == len(days):
#             return 0
#         if lastDayOfPass >= days[index]:
#             return self.helper(index + 1, days, costs, lastDayOfPass)

#         oneDay = costs[0] + self.helper(index + 1, days, costs, days[index])
#         sevenDay = costs[1] + self.helper(index + 1, days, costs, days[index] + 6)
#         thirtyDay = costs[2] + self.helper(index + 1, days, costs, days[index] + 29)
#         return min(oneDay, sevenDay, thirtyDay)
    


# class Solution:
#     def mincostTickets(self, days, costs):
#         n = len(days)
#         memo = [[-1 for _ in range(400)] for _ in range(n)]
#         minimumCost = self.helper(0, days, costs, 0, memo)
#         return minimumCost

#     def helper(self, index, days, costs, lastDayOfPass, memo):
#         if index == len(days):
#             return 0
#         if lastDayOfPass >= days[index]:
#             memo[index][lastDayOfPass] = self.helper(
#                 index + 1, days, costs, lastDayOfPass, memo
#             )
#             return memo[index][lastDayOfPass]

#         if memo[index][lastDayOfPass] != -1:
#             return memo[index][lastDayOfPass]

#         oneDay = costs[0] + self.helper(index + 1, days, costs, days[index], memo)
#         sevenDay = costs[1] + self.helper(index + 1, days, costs, days[index] + 6, memo)
#         thirtyDay = costs[2] + self.helper(
#             index + 1, days, costs, days[index] + 29, memo
#         )
#         memo[index][lastDayOfPass] = min(oneDay, sevenDay, thirtyDay)
#         return min(oneDay, sevenDay, thirtyDay)
    

# class Solution:
#     def mincostTickets(self, days, costs):
#         memo = {}
#         minimumCost = self.helper(0, days, costs, 0, memo)
#         return minimumCost

#     def helper(self, index, days, costs, lastDayOfPass, memo):
#         if index == len(days):
#             return 0
#         if lastDayOfPass >= days[index]:
#             memo[(index, lastDayOfPass)] = self.helper(
#                 index + 1, days, costs, lastDayOfPass, memo
#             )
#             return memo[(index, lastDayOfPass)]

#         if (index, lastDayOfPass) in memo:
#             return memo[(index, lastDayOfPass)]

#         oneDay = costs[0] + self.helper(index + 1, days, costs, days[index], memo)
#         sevenDay = costs[1] + self.helper(index + 1, days, costs, days[index] + 6, memo)
#         thirtyDay = costs[2] + self.helper(
#             index + 1, days, costs, days[index] + 29, memo
#         )
#         memo[(index, lastDayOfPass)] = min(oneDay, sevenDay, thirtyDay)
#         return min(oneDay, sevenDay, thirtyDay)


class Solution:
    def mincostTickets(self, days, costs):
        n = len(days)
        memo = [[0] * 400 for _ in range(n + 1)]

        for index in range(n - 1, -1, -1):
            for lastDay in range(400):
                if lastDay >= days[index]:
                    memo[index][lastDay] = memo[index + 1][lastDay]
                else:
                    oneDay = costs[0] + memo[index + 1][min(days[index], 399)]
                    sevenDay = costs[1] + memo[index + 1][min(days[index] + 6, 399)]
                    thirtyDay = costs[2] + memo[index + 1][min(days[index] + 29, 399)]
                    memo[index][lastDay] = min(oneDay, sevenDay, thirtyDay)

        return memo[0][0]
