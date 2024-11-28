# // Time Complexity : O(n) where n is the number of days between day 1 to last day inclusive in the Days array
# // Space Complexity : O(n) space
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
# bottom - up solution

class Solution:
    # top-down DP
    def mincostTickets(self, D: List[int], C: List[int]) -> int:
        dp = [-1 for _ in range(D[-1]+1)]
        def helper(D,C,i,j,dp):
            if i <= 0: return 0
            if dp[i] != -1: return dp[i]
            if D[j] == i:
                x = C[0] + helper(D,C,i-1,j-1,dp)
                y = C[1] + helper(D,C,i-7,j-1,dp)
                z = C[2] + helper(D,C,i-30,j-1,dp)
                dp[i] = min(x,y,z)
            else:
                dp[i] = helper(D,C,i-1,j,dp)
            return dp[i]
        helper(D,C,D[-1],len(D)-1,dp)
        return dp[D[-1]]
    
    # # bottom-up DP
    # def mincostTickets(self, D: List[int], C: List[int]) -> int:
    #     dp = [0 for _ in range(D[-1]+1)]
    #     i = 1
    #     j = 0
    #     while i < len(dp):
    #         if D[j] == i: 
    #             x = C[0]
    #             y = C[1]
    #             z = C[2]
    #             if i-1 >= 0: x += dp[i-1]
    #             if i-7 >= 0: y += dp[i-7] 
    #             if i-30 >= 0: z += dp[i-30] 
    #             dp[i] = min(x,y,z)
    #             j+=1
    #         else:
    #             dp[i] = dp[i-1]
    #         i += 1
    #     return dp[-1]