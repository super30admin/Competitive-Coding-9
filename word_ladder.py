# tc : O(26*n*n)
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0  # O(1) best
        graph = dict()
        for word in wordList:
            graph[word] = []
        # build graph
        for word in wordList:
            # first char change
            for i in range(len(word)):
                for k in range(0,26):
                    temp = word[0:i] +chr(ord('a') + k) +word[i+1:]
                    if temp in wordList and temp != word:
                        graph[word].append(temp)
        for i in range(len(beginWord)):
                for k in range(0,26):
                    temp = beginWord[0:i] +chr(ord('a') + k) +beginWord[i+1:]
                    if temp in wordList and temp != beginWord:
                        if beginWord in graph:
                            graph[beginWord].append(temp)
                        else:
                            graph[beginWord] = [temp]
        #print(graph)
        #print("------------")
        startNode = beginWord
        self.res = 0
        def bfs(graph, node):
            queue = []
            final_res = []
            visited = dict()
            for k in wordList:
                visited[k] = False
            queue.append(node)
            visited[node] = True
            while (queue):
                l = len(queue)
                self.res = self.res + 1
                for _ in range(l):
                    tnode = queue.pop(0)
                    for child in graph[tnode]:
                        if visited[child] == False:
                            queue.append(child)
                            visited[child] = True
                            if child == endWord:
                                return self.res + 1
                #print(queue)
            return 0
        return bfs(graph, beginWord)


