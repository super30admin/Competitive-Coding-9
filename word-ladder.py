# Time O(m * n^2 * 26)
# Space O(2m + 26)
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        chars = "abcdefghijklmnopqrstuvwxyz"
        dq = deque()
        dq.append(beginWord)
        n = len(beginWord)
        minL = 0
        level = 0
        while len(dq) > 0: #
            length = len(dq)
            level += 1
            for j in range(length): # O(m) length of wordList
                curr = dq.popleft()
                for i in range(n): # O(n)
                    for c in chars: # O(26)
                        nw = curr[:i] + c + curr[i+1:] #O(n)
                        if nw in wordSet:
                            if nw == endWord:
                                if minL == 0:
                                    minL = level + 1
                                else: minL = min(minL, level + 1)
                            dq.append(nw)
                            wordSet.remove(nw)
        return minL