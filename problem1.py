# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode :yes

from ast import List
from collections import deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque()
        q.append((beginWord, 1))
        hash_set = set(wordList)

        if beginWord in hash_set:
            hash_set.remove(beginWord)
        
        while q:
            word, steps = q.popleft()
            if word == endWord:
                return steps

            for i in range(len(word)):
                for ch in "abcdefghijklmnopqrstuvwxyz":
                    replaceChar = list(word)
                    replaceChar[i] = ch
                    replaceWord = ''.join(replaceChar)

                    if replaceWord in hash_set:
                        hash_set.remove(replaceWord)
                        q.append((replaceWord, steps + 1))
            
        return 0



        