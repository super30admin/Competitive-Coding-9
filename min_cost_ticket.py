#Time Complexity: O(max(days)), number of coins times amount
#Space Complexity: O(max(days))
#Did this code successfully run on leetcode: yes\
#Since we only have 365 days, technically time and space would be O(1)
'''
Brute force:
Start with the whole array of days,
make a choice between buying a 7 days,1 day or 30 days
put the remaining days that you have to buy ticket for.
Update the money you spent, take the branch with the smallest cost.
            [1,3,6,7,8,20]
                  /|\                                                 
                /  |  \                                              
    [3,6,7,8,20] [8,20] []                                                   
            /                                                       
    [6,7,8,20]                                                       
          /                                                         
    [7,8,20]                                                            
        /
    [8,20]
We see a repeated subproblem                                                     
'''
'''
Main idea: have a dp array representing all the days between 0 and max(days). If the day is in days (we create a hashset for fast lookup)
we check what's better: (day-1)+cost[0],(day-7)+cost[1],(day-30)+cost[2]. Is it better to pay the optimal price until day-X, and then pay the the ticket for X days? What is X? We take the min at each step and return the last element of the array
'''
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        #edge case
        if not days:
            return 0
        h=set(days)
        max_days=max(days)
        dp=[0]*(max_days+1)
        #We only need an array filled with the in-betweens
        for i in range(1,len(dp)):
            if i in h:
                dp[i]=min(dp[max(0,i-1)]+costs[0],dp[max(0,i-7)]+costs[1],dp[max(0,i-30)]+costs[2])
            else:
                dp[i]=dp[i-1]
        return dp[-1]
