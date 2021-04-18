'''
T = O(n)
S = O(n)

Approach:
Maintain a days array that is of lenght of the maximum day.
At aevery day which travel is required find the minimum cost incured by considering the previous minimum cost
there by at the last day we will get the minimum cost
'''
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days or not costs:
            return 0
        daysarray = [0 for i in range(max(days)+1)]
        
        for i in range(1,len(daysarray)):
            if i in days:
                case1 = daysarray[max(i-1,0)] + costs[0]
                case2 = daysarray[max(i-7,0)] + costs[1]
                case3 = daysarray[max(i-30,0)] + costs[2]
                daysarray[i] = min(case1,case2,case3)
            else:
                daysarray[i] = daysarray[i-1]
        return daysarray[-1]
            
        