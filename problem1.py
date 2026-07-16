"""
1. We have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by these n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array or number at the ith position is divisible by i. 
2. We use backtracking to find all the possible arrangements of the numbers from 1 to n. We keep track of the current index and the numbers that have already been used in the arrangement.
3. If we reach a valid arrangement, we increment our count.

TC: O(n!) -> all possible arrangements of n numbers in worst case have to be explored
SC: O(n) -> recursion stack
"""

class Solution:
    def countArrangement(self, n: int) -> int:
        self.count = 0
        self.backtrack(n,1,[])
        return self.count
    
    def backtrack(self, N, idx, temp):
        if len(temp) == N:
            self.count += 1
            return 

        for i in range(1,N+1):
            if i not in temp and (i % idx == 0 or idx % i ==0):
                temp.append(i)
                self.backtrack(N,idx+1, temp)
                temp.pop()



        