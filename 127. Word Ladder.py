#time:O(no.of words for iterating the queue* len of words  * no. of words to check the dictionary pattern)
#space: O(no.of words* word len)
from collections import deque,defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        if endWord not in wordList:
            return 0
        n=len(beginWord)
        bigwordlist=defaultdict(list)
        wordList.append(beginWord)
        for word in wordList:
            for i in range(n):
                pattern=str(word[:i]+'*'+word[i+1:])
                bigwordlist[pattern].append(word)
        q=deque()
        q.append(beginWord)
        visited=set()
        visited.add(beginWord)
        cnt=1
        while len(q)!=0:
            size=len(q)
            print('q is',q)
            for _ in range(size):
                curr=q.popleft()
                if curr == endWord:
                    return cnt
                for i in range(n):
                    pattern= str(curr[:i]+'*'+curr[i+1:])
                    if pattern in bigwordlist:
                        neighbours=bigwordlist[pattern]
                        for nei in neighbours:
                            if nei not in visited:
                                q.append(nei)
                                visited.add(nei)
            cnt+=1
        return 0
