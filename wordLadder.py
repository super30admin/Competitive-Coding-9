# Time Complexity - O(m^2*n)
# SC - O(N)

from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset = set(wordList)
        q = deque()
        q.append((beginWord,1))
       
        while q :
            curr,count = q.popleft()
            if curr == endWord:
                return count
            for i in range(len(curr)):
                for j in range(ord('a'),ord('z')+1):
                    word = curr[:i] + chr(j) + curr[i+1:]
                    if word in wordset:
                        q.append((word,count+1))
                        wordset.remove(word)
                    
        return 0