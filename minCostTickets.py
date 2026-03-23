class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [-1]*len(days)

        def binSearch(low, high, target):
            while low<high:
                mid = (low+high)//2
                if days[mid]<target:
                    low = mid+1
                elif days[mid]==target:
                    return mid+1
                else:
                    high = mid
            
            if days[low]<=target:
                return low+1
            
            return low
                

        def helper(idx):
            #base
            if idx==len(days):
                return 0
            if dp[idx]!=-1:
                return dp[idx]
            #logic
            curr_day = days[idx]

            # 1 day pass
            one = costs[0]+helper(idx+1)

            # 7 day pass
            s_idx = binSearch(idx, len(days)-1, curr_day+6)
            seven = costs[1]+helper(s_idx)

            # 30 day pass
            t_idx = binSearch(idx, len(days)-1, curr_day+29)
            thirty = costs[2]+helper(t_idx)

            dp[idx] = min(one, seven, thirty)
            return dp[idx]
        
        return helper(0)

