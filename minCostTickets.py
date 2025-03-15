#Time Complexity = O(n)
#Space Complexity = O(n)

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days:
            return 0
        
        last_day = days[-1]
        all_days = set(days)
        memo = [-1] * (last_day + 1)

        def recursion(index):
            if index > last_day:
                return 0
            
            if memo[index] != -1:
                return memo[index]
            
            if index not in all_days:
                memo[index] = recursion(index + 1)
                return memo[index]

            sum1 = recursion(index + 1) + costs[0]
            sum7 = recursion(index + 7) + costs[1]
            sum30 = recursion(index + 30) + costs[2]

            memo[index] = min(sum1, sum7, sum30)
            return memo[index]

        return recursion(days[0])