# Time Complexity : O(2^N*L) where N is the number of words in wordList and L is the length of each word
# Space Complexity : O(N) as we are using a queue to store the words
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using BFS to solve this problem.
# I am starting from the beginWord and exploring all possible transformations.
# I am using a queue to store the words to be explored along with the current length of the transformation sequence.
# I am using a set to store the wordList for O(1)
# I am exploring all possible one letter transformations for each word by changing each character to every letter from 'a' to 'z'.
# If the transformed word is in the wordSet, I add it to the queue and remove it from the wordSet to avoid cycles.
# If I reach the endWord, I return the current length of the transformation sequence.
# If no transformation sequence is found, I return 0.


from collections import deque
from typing import List
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        q = deque([(beginWord,1)])
        if beginWord in wordSet:
            wordSet.remove(beginWord)
        while q:
            curr,conuter = q.popleft()
            if curr == endWord:
                return conuter
            for i in range(len(beginWord)):
                for ch in range(26):
                    trans = curr[:i] + chr(ord('a') + ch) + curr[i+1:]
                    if trans in wordSet:
                        q.append((trans,conuter+1))
                        wordSet.remove(trans)
                    
        return 0


        