#Time Complexity O(n)
#Space Complexity O(1)
'''
Find the peaks, expand left and right from them and increase length, while 
not forgetting the peak itself as an element.
'''

class Solution:
    def longestMountain(self, A: List[int]) -> int:
        #edge case
        if len(A)<3: return 0
        max_length=0
        i=1
        r,l=False,False
        while i<len(A)-1:
            length=0
            left=i
            right=i+1
            if A[i-1]<A[i] and A[i]>A[i+1]:
                while left>=0 or right<=len(A)-1:
                    if left>0 and A[left]>A[left-1]:
                        length+=1
                        left-=1
                        l=True
                    if right<=len(A)-1 and A[right]<A[right-1]:
                        length+=1
                        right+=1
                        r=True
                    if not r and not l: break
                    r,l=False,False   
                max_length=max(length+1,max_length)
            i=right
        return max_length
