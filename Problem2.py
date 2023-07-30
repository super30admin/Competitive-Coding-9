#Time complexity is: O(n)+O(max(n))
#Space complexity is: O(max(n))
#No issues faced while coding
#Code ran successfully on leetcode

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #initializing the maxi value to 0
        maxi=0
        #We will find the maximum value by oterating tough each value in the nums array
        for i in nums:
            if(i>maxi):
                maxi=i
        #We will be creating an arr with initial values as 0
        arr=[0 for i in range(0,maxi+1)]
        #We will be going thorugh each value in nums array and we will make note
        #of their frequencies in the respective indexes of the arr list
        for i in range(0,len(nums)):
            curr=nums[i]
            arr[curr]+=curr
        #we are going to initialize skip and take values
        skip=0
        take=0
        #We will be going through value in the arr
        for i in range(0,len(arr)):
            #We will be finding the skip and take values at each element in the arr
            temp=skip
            skip=max(skip,take)
            take=temp+arr[i]
        #Finally we will be returning the maximum value of skip and take values
        return max(skip,take)

