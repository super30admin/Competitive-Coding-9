# https://leetcode.com/problems/word-ladder/

from collections import deque
import string


class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0
        q = deque()
        q.append(beginWord)
        level = 0
        while q:
            qs = len(q)
            for _ in range(qs):
                currWord = q.popleft()
                if currWord == endWord:
                    return level + 1
                for i in range(len(currWord)):
                    for letter in string.ascii_lowercase:
                        nextWord = currWord[:i] + letter + currWord[i + 1 :]
                        if nextWord in wordSet:
                            q.append(nextWord)
                            wordSet.remove(nextWord)
            level += 1
        return 0
