"""
A transformation sequence from word beginWord to word endWord 
using a dictionary wordList is a sequence of words 
beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord 
does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, 
return the number of words in the shortest transformation sequence 
from beginWord to endWord, or 0 if no such sequence exists.
"""

# Time Complexity : O(m2 * n)
# Space Complexity : O(m2 * n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List
import collections
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList) -> int:
        
        if endWord not in wordList:
            return 0
        
        nei = collections.defaultdict(list)
        wordList.append(beginWord)
        
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*" + word[j + 1:]
                nei[pattern].append(word)
                
        visit = set([beginWord])
        q = deque([beginWord])
        res = 1
        
        while q:
            for i in range(len(q)):
                word = q.popleft()
                
                if word == endWord:
                    return res
                
                for j in range(len(word)):
                    pattern = word[:j] + "*" + word[j + 1:]
                    for neiWord in nei[pattern]:
                        if neiWord not in visit:
                            visit.add(neiWord)
                            q.append(neiWord)
                            
            res += 1
            
        return 0