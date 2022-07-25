# time complexity is o(nk* 26), where n is the size of the input, k is the size of word
# space complexity is o(n), where n is the size of the input
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        from collections import deque
        q = deque()
        wordSet = set()
        for word in wordList:
            wordSet.add(word)
        q.append(beginWord)
        level = 1
        while(len(q) != 0):
            n = len(q)
            for k in range(n):
                curr = q.popleft()
                for i in range(len(curr)):
                    for j in range(26):
                        rp = chr(ord('a') + j)
                        nw = curr[:i] + rp + curr[i+1 : ]
                        if(nw in wordSet and curr[i] != rp):
                            q.append(nw)
                            wordSet.remove(nw)
                            if(nw == endWord):
                                return level + 1
                
            level += 1
        return 0
                
                
        