# Time Complexity :
# O(N)  - Size of the List

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We go through the array by trying all choices at any given position - we first pick 1 day pass, compute the cost for the rest of the array with the given passes and add 1 day pass cost. Then do the same for 7 day pass and 30 day pass as well.
#We also do the same at every subsequent level - we do an exhaustive search over all possibilities
#We also see that a lot of these problems will be solved multiple times and hence store the rest after we solve it once and use it over and over
#At the end, we return the best cost stored found among all the choice combinations 

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        self.choices = [1,7,30]
        self.best_costs = [-1] * len(days)
        best_val = self.helper(days,0,costs)

        return self.best_costs[0]

    def helper(self,days,idx,costs):
        if idx >= len(days):
            return 0

        if self.best_costs[idx] != -1 :
            return self.best_costs[idx]

        curr_day = days[idx]
        ans = 1000000

        for i,choice in enumerate(self.choices):
            new_idx = idx
            for j in range(idx,idx+choice):
                if j < len(days) and days[j] < curr_day + choice :
                    new_idx += 1
                else :
                    break
            ans = min(ans,self.helper(days,new_idx, costs)+costs[i])

        self.best_costs[idx] = ans
        return self.best_costs[idx]
