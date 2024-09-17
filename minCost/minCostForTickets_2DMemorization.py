'''
Time Complexity: 0(4*m)
Space Complexity : 0(4*m)
'''
class Solution:
    
    def getValue(self,memory2D,days,row,col,i):
        
        # get the endDay period
        day = days[i]
        passValidity = 7
        if col == 2:
            passVaidity = 30
        
        end = day + passValidity -1
        
        # set count and itr
        idx = i+1
        count = 1
        
        # iterate the days list
        while idx != len(days) and days[idx] <= end:
            idx += 1
            count += 1
        
        # generate val and return
        if idx == len(days):
            # breech
            return 0
        else:
            return memory2D[row-count][3]
            
    
    def memorization2D(self,days,costs):
        
        # 1. initialize memory2D
        memory2D = [[None for col in range(0,len(costs)+1)] for row in range(0,len(days))]
        
        # 2. fill first row values by default
        memory2D[0][0] = costs[0]
        memory2D[0][1] = costs[1]
        memory2D[0][2] = costs[2]
        memory2D[0][3] = min(costs)
        
        # 3. iterate the memory2D
        '''fillUp the memory2D by iterating days from behind'''
        
        # index for iterating the days list from behind
        i = len(days)-2
        
        for row in range(1,len(memory2D)):
            minVal = None
            for col in range(0,len(memory2D[0])-1):
                
                if col == 0:
                    memory2D[row][col] = costs[0] + memory2D[row-1][3]
                    minVal = memory2D[row][col]
                    continue
                else:
                    # create a function getValue
                    val = self.getValue(memory2D, days, row, col, i)
                    memory2D[row][col] = costs[col] + val
                    minVal = min(minVal,memory2D[row][col])
            '''end of col iteration'''
            # set the minVal in the 3rd col
            memory2D[row][3] = minVal
            
            # update i iterator in days list
            i-= 1
        '''end of fillUp of memory2D'''
        
        print("Memory2D is:\t",memory2D)
        return memory2D[-1][-1]
        
            
                    
    def mincostTickets(self, days, costs) -> int:
        return self.memorization2D(days,costs)


sol = Solution()
print(sol.mincostTickets([1,4,6,7,8,20], [2,7,15]))