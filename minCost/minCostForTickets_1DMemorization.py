'''
Time Complexity: 0(m)
Space Complexity : 0(m)
'''
class Solution:
    
    def getValue(self,memory1D,days,i,idx,j):
        
        # get the endDay period
        day = days[i]
        passValidity = 7
        if j == 2:
            passVaidity = 30
        
        end = day + passValidity -1
        
        # iterate the days list
        while idx != len(days) and days[idx] <= end:
            idx += 1
        
        # generate val and return
        if idx == len(days):
            # breech
            return 0
        else:
            return memory1D[idx]
            
    
    def memorization1D(self,days,costs):
        
        # 1. initialize memory1D
        memory1D = [None for index in range(0,len(days))]
        
        # 2. fill last col value by default
        memory1D[-1] = min(costs)
        
        # 3. iterate the memory1D
        '''fillUp the memory1D by iterating days from behind'''
        
        # index for iterating the days list from behind
        for i in range(len(memory1D)-2,-1,-1):
            idx = i+1
            
            minCost = None
            # iterate the costs list
            for j in range(0,len(costs)):
                
                if j == 0:
                    minCost = costs[j] + memory1D[i+1]
                
                else:
                    tempCost = costs[j] + self.getValue(memory1D,days,i,idx,j)
                    minCost = min(minCost,tempCost)
            '''end of costs iteration'''
            
            memory1D[i] = minCost
        '''end of memory1D iteration'''
            
        print("Memory1D is:\t",memory1D)
        
        return memory1D[0]
                    
    def mincostTickets(self, days, costs) -> int:
        return self.memorization1D(days,costs)


sol = Solution()
print(sol.mincostTickets([1,4,6,7,8,20], [2,7,15]))