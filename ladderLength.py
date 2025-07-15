# TimeComplexity:O(n*L*L)
# SpaceComplexity:O(n*L)
# Approach: convert each word in wordlist into a pattern ,add pattern as key and words as vals now perform bfs on given startword with various possible patterns
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        d=defaultdict(list)
        if endWord not in  wordList:return 0
        for word in wordList:
            for i in range(len(word)):
                pattern=word[:i]+"*"+word[i+1:]
                d[pattern].append(word)
        visited=set()
        q=deque([[beginWord,1]])
        #bfs
        ans=float('inf')
        while(q):
            l=q.popleft()
            # print(l)
            word,c=l[0],l[1]
            for i in range(len(word)):
                pattern=word[:i]+"*"+word[i+1:]
                if pattern in d:
                    for j in d[pattern]:

                        if j==endWord:
                            ans=min(ans,c)
                        if j not in visited:
                            visited.add(j)
                            q.append([j,c+1])
            
        if ans==float('inf'):return 0
        return min(ans,c)+1
