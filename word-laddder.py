# Time Complexity: O(M^2*N) - M is length of each word and N is total number of words
# Space Complexity: O(M^2*N)
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        n = len(beginWord)
        # Adjacency list - Intermediate Word::Word
        adjList = collections.defaultdict(list)
        for word in wordList:
            for i in range(n):
                adjList[word[:i]+'*'+word[i+1:]].append(word)
        
        q = collections.deque([(beginWord, 1)])
        visited = set(beginWord)
        
        # BFS
        while q:
            numnodes = len(q)
            for _ in range(numnodes):
                curr, d = q.popleft()
                for i in range(n):
                    intermediate = curr[:i] + '*' + curr[i+1:]
                    for word in adjList[intermediate]:
                        if endWord == word:
                            return d+1
                        if word not in visited:
                            q.append((word, d+1))
                            visited.add(word)
        return 0                        