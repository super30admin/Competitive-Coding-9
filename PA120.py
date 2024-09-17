#Time Complexity - O(n)
#Space Complexity - O(n)
class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        d = set(days)
        m = days[-1]
        arr = [0] * (m + 1)
        oned,two,threed = 9999,9999,9999
        for i in range(1,len(arr)):
            if i not in d:
                arr[i] = arr[i-1]
            else:
                #1daypass
                oned = arr[i-1] + costs[0]
                #7daypass
                if i >= 7:
                    twod = arr[i-7] + costs[1]
                else:
                    twod = costs[1]
                #30daypass
                if i >= 30:
                    threed = arr[i-30] + costs[2]
                else:
                    threed = costs[2]
                arr[i] = min(oned,twod,threed)
        #print(arr)
        return arr[-1]