class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        """DP
        Time complexity-O(n)
        Space complexity-O(n)"""
        dparr=[0 for _ in range(days[len(days)-1]+1)]
        for i in range(1, len(dparr)):
            if i in days:
                dparr[i]=min(dparr[i-1]+costs[0],dparr[max(0,i-7)]+costs[1],dparr[max(i-30,0)]+costs[2])
            else:
                dparr[i]=dparr[i-1]
        print(dparr)
        return dparr[len(dparr)-1]  