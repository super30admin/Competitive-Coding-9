# The time complexity is: O(m*n^2), first to make the adjList is O(m*n) and then for the BFS is O(n). hence O(m*n*n)

# The space is O(m*n) for the queue data structure.

# The intuition here is to first create a adj list with the list of neigbours. After that do Breadth first search to get the shorted path using queue data structure.
# if any of the word matches the endword we return the result. If it does not then return 0

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0
        adjList = defaultdict(list)
        if beginWord not in wordList:
            wordList.append(beginWord)

        for word in wordList:
            for i in range(len(word)):
                pattern = word[:i] + "*" + word[i + 1:]
                adjList[pattern].append(word)
        queue = deque([beginWord])
        visit = set([beginWord])
        res = 1
        while queue:
            for i in range(len(queue)):
                word = queue.popleft()
                if word == endWord:
                    return res
                for j in range(len(word)):
                    pattern = word[:j] + "*" + word[j + 1:]
                    for child in adjList[pattern]:
                        if child not in visit:
                            visit.add(child)
                            queue.append(child)
            res += 1

        return 0