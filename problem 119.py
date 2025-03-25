#  https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:

        n = len(days) - 1
        dp = [0] * (days[n]+1)
        day_set = set(days)
         
        for i in range(1,len(dp)):
            if i in day_set:
                dp[i] = min(
                    dp[i-1] + costs[0], # if for that day one day pass is taken
                    min(dp[max(0,i-7)] + costs[1], # if 7 day pass is taken
                    dp[max(0,i-30)] + costs[2])) # if 30 days pass is taken
                    # take minimum of all possibilities.
            else:
                dp[i] = dp[i-1]
        
        return dp[len(dp)-1]

# here I converted the days array to set for O(1) lookup, 
# otherwise it would have been O(n * m) n = len of dp, m = len(days)


# TC: 365 --> O(1)
# SC: 365 --> O(1)

'''
my previous mistake is with this test case
days =
[1,2,3,4,6,8,9,10,13,14,16,17,19,21,24,26,27,28,29]
costs =
[3,14,50]
for my code I was getting 54 but the answer is 50
basically taking 30 day ticket worth 50 for all days is the best choice here
but that condition is not satisfied because it won't go into this statement  i-30>0 when i = 29
so I need to consider taking all possible tickets for all possible days and choose minimum of these choices.
so go back 7 days and check
go back 30 days and check
if it doesn't exist then from 0 we consider that option.
one more optimization I did is taking days as a set for O(1) look up
'''