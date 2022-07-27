# TC: O(M^2 x N) - M is len of each word and N is total words
# SC: O(M^2 x N) - M is len of each word and N is total words
from collections import defaultdict, deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        graph = defaultdict(list)
        
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + '*' + word[j+1:]
                graph[pattern].append(word)
        # print(graph)
        # Conduct BFS using a Q and visited set to find word
        visited = {beginWord}
        q = deque()
        q.append(beginWord)
        # iterate over queue
        res = 1
        while q:
            size = len(q)
            # print(q)
            for i in range(size): # for size of queue, pop and process all words
                word = q.popleft()
                if word == endWord:
                    return res
                # process adj list for the word using wildcards
                for j in range(len(word)):
                    pattern = word[:j] + '*' + word[j+1:]
                    for adjwrd in graph[pattern]:
                        # print(adjwrd)
                        if adjwrd not in visited:
                            visited.add(adjwrd)
                            q.append(adjwrd)
                
            res += 1
        return 0