# Time Complexity : O(M^2 * N) where M is avg size of a word & N is size of our word list
# Space Complexity : O(M * N) where M is avg size of a word & N is size of our word list
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

from collections import deque 

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque()
        hashset = set(wordList)
        if endWord not in hashset:
             return 0
        q.appendleft(beginWord)
        count = 1
        
        while len(q) > 0:
            qlen = len(q) 
            for _ in range(qlen):
                curr = q.pop()
                if (curr == endWord):
                    return count
                for i in range(len(curr)):
                    for l in "abcdefghijklmnopqrstuvwxyz":
                        nextWord = curr[:i] + l + curr[i + 1:]
                        if (nextWord in hashset and nextWord != curr):
                            q.appendleft(nextWord)
                            hashset.remove(nextWord)
                            
            count += 1
        return 0