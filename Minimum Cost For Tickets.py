# Time Complexity: O(W), where W=365 is the maximum numbered day in your travel plan.
# Space Complexity: O(W).

class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        DP = [0]*(days[-1]+1)
        day = set(days)
        
        #print(DP)
        #print(day)
        
        for i in range(1,days[-1]+1):
            print(i)
            if i not in day:
                DP[i]=DP[i-1]
            else:
                DP[i] = min(DP[i-1]+costs[0], DP[max(0,i-7)]+costs[1], DP[max(0,i-30)]+costs[2])
            print(DP)
            print(" ")
        return DP[-1]

