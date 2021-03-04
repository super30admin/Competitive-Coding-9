class Solution:
    
    """
    Description: find minimum cost of tickets for a travel plan
    
    Time Complexity: O(max(days))
    Space Complexity: O(max(days))
    
    Approach:
    - initialize a dp array with size = max(days) + 1
    - starting from 0th index as 0th day, use the logic below to fill values in dp array
      + if traveling on a index match to a day: find minimum cost starting from the begining
      + if not, just copy the cost from previous index
    - return last value of the dp array at the end as minimum ticket cost
    """
    
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        
        dp_array = [0]*(max(days) + 1)
        set_days = set(days) # O(1) if search from a set instead of list
        
        for i in range(1, len(dp_array)):
            if i in set_days:
                dp_array[i] = min(dp_array[i - 1] + costs[0],
                              min(dp_array[max(i - 7, 0)] + costs[1],
                                  dp_array[max(i - 30, 0)] + costs[2]))
            else:
                dp_array[i] = dp_array[i - 1]

        return dp_array.pop()
                
