import collections
class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
        graph = self.build_graph(wordList)
        return self.bfs(graph, beginWord, endWord )

    def build_graph(self, wordList):
        graph_dic = defaultdict(list)
        for word in wordList:
            for key in self.getOptions(word):
                graph_dic[key].append(word)

        return graph_dic

    def getOptions(self,word ):
        l = []
        for i in range(len(word)):
            key = word[:i] + "_" + word[i + 1:]
            l.append(key)
        return l

    def bfs(self, graph, start, end):
        queue = collections.deque([(start, 1)])
        # Visited to make sure we don't repeat processing same word.
        visited = set()
        while queue:
            current_word, level = queue.popleft()

            for intermediate_word in self.getOptions(current_word):
                # Intermediate words for current word
                if intermediate_word in graph.keys():
                    # Next states are all the words which share the same intermediate state.
                    for word in graph[intermediate_word]:
                        # If at any point if we find what we are looking for
                        # i.e. the end word - we can return with the answer.
                        if word == end:
                            return level + 1
                        # Otherwise, add it to the BFS Queue. Also mark it visited
                        if word not in visited:
                            visited.add(word)
                            queue.append((word, level + 1))
                    graph[intermediate_word] = []
        return 0