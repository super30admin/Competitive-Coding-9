#Time complexity: O(n^2*m)
#Space complexity: O(n)
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        wordList.append(beginWord)
        
        neig = {}
        
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*"+word[j+1:]
                if pattern not in neig:
                    neig[pattern] = []
                neig[pattern].append(word)
                
        q = deque()
        q.append(beginWord)
        vis = set()
        vis.add(beginWord)
        cnt = 1
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if curr == endWord:
                    return cnt
                for j in range(len(curr)):
                    pattern = curr[:j] + "*" + curr[j+1:]
                    for nei in neig[pattern]:
                        if nei not in vis:
                            q.append(nei)
                            vis.add(nei)
            cnt += 1
            
        return 0
                
        
