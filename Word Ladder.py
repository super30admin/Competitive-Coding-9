""""// Time Complexity : O(n^2m) n total words m length of each word
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque()
        wordSet = set(wordList)
        q.append(beginWord)
        level = 1

        while q:
            size = len(q)
            for k in range(size):
                curr = q.popleft()
                l = []
                for i in range(len(curr)):
                    l.append(curr[i])
                for i in range(len(l)):
                    temp = l[i]
                    for j in range(26):
                        char = chr(ord('a') + j)
                        l[i] = char
                        new = ''.join(l)
                        if new in wordSet:
                            q.append(new)
                            wordSet.remove(new)
                            if new == endWord:
                                return level + 1
                    l[i] = temp

            level += 1
        return 0
# class Solution:
#     def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
#         q = deque()
#         wordSet = set(wordList)
#         q.append(beginWord)
#         level = 1
#         while q:
#             size = len(q)
#             for k in range(size):
#                 curr = q.popleft()
#                 for i in range(len(curr)):
#                     for j in range(26):
#                         char = chr(ord('a') + j)
#                         new = curr[:i] + char + curr[i+1 : ]
#                         if new in wordSet and curr[i] != char:
#                             q.append(new)
#                             wordSet.remove(new)
#                             if new == endWord :
#                                 return level + 1

#             level += 1
#         return 0