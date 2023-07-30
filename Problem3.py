#Time complexity is: O(maxi)
#Space complexity is: O(1)
#No issues faced while coding
#Code ran successfully on leetcode

class Solution(object):
    def mincostTickets(self, days, costs):
        """
        :type days: List[int]
        :type costs: List[int]
        :rtype: int
        """
        #We are creating a hashset and we are assignning the max variable to least integer value
        hSet=[]
        maxi=-1*float('inf')
        #We will be going through all the values in the days array and we will find the maximum value
        for i in days:
            hSet.append(i)
            maxi=max(maxi,i)
        #Creating a new list to solve the problem in a dynamic fashion
        dp=[0 for i in range(0,maxi+1)]
        #Initializing the first value to 0
        dp[0]=0
        #We will be going through each value from 1 to maximum value
        for i in range(1,len(dp)):
            #If i is not present in the hashset, we will take previous value
            if(i not in hSet):
                dp[i]=dp[i-1]
                continue
            #If i is present in the hSet, the we will taking the mininmum value of the below condition
            dp[i]=min(dp[i-1]+costs[0],min(dp[max(0,i-7)]+costs[1],dp[max(0,i-30)]+costs[2]))
        #FInally we will be returning the final value in the dp array
        return dp[len(dp)-1]
