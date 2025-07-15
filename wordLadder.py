
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        graph = collections.defaultdict(list)
        wordList.append(beginWord)

        for w in wordList:
            for i in range(len(w)):
                graph[w[:i] + '*' + w[i + 1:]].append(w)
        
        q = collections.deque()

        q.append([beginWord, 1])
        visited = set()
        while q:
            node, dist = q.popleft()

            for i in range(len(node)):
                tempW = node[:i] + '*' + node[i + 1:]
                for nei in graph[tempW]:
                    if nei == endWord:
                        return 1 + dist

                    if nei in visited:
                        continue
                    visited.add(nei)
                    q.append([nei, dist + 1])
        return 0