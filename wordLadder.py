from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """BFS approach using hashmaps, visitedmap
        Time complexity-O(n^2)
        Space complexity-O(n)"""
        hashmap={}
        q=deque()
        for i in wordList:
            for j in range(len(i)):
                newword=i[:j]+"*"+i[j+1:]
                if newword not in hashmap:
                    hashmap[newword]=[]
                hashmap[newword].append(i)
        q.append(beginWord)
        visitedmap={}
        visitedmap[beginWord]=True
        count=0
        while q:
            count+=1
            qlen=len(q)
            if qlen==0:
                return 0
            while qlen:
                word=q.popleft()
                if word==endWord:
                    return count
                for i in range(len(word)):
                    hashword=word[:i]+"*"+word[i+1:]
                    if hashword in hashmap:
                        for k in hashmap[hashword]:
                            if k not in visitedmap:
                                q.append(k)
                                visitedmap[k]=True
                qlen-=1
        return 0
                        
        
        