# // Time Complexity : o(n^2*l) where n is the number of words and l is time for comparison
# // Space Complexity : o(N*L)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# the idea is to do a bfs on the words differing by 1 character and keep doing so until we reach destination word

from typing import List,collections
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordset = set(wordList)
        if endWord not in wordset: return 0
        # add the first word to queue and the visited set 
        q = collections.deque()
        q.append((beginWord,1))
        visited = set([beginWord])
        def mismatch(w1,w2):
            mismatch = 0
            for i in range(len(w1)):
                if w1[i]!=w2[i]:
                    mismatch+=1
                if mismatch>1:
                    return False
            return mismatch == 1
        while q:
            for i in range(len(q)):
                # find neighbours with mismatch count == 1 and if the end word is found return size
                # add those neighbours with mismatch ==1
                curr, size = q.popleft()
                if curr == endWord:
                    return size
                for word in wordList:
                    # find the mismatch
                    if word not in visited and mismatch(word, curr):
                        q.append((word,size+1))
                        visited.add(word)
        return 0