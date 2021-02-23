# Time complexity - O(N^2 * M) ->  N: size of word,M : len of wordlist
# Space Complexity: - O(N^2 * M) ->  N: size of word,M : len of wordlist
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this: None
# Approach : Graph creation. Apply bfs to reach endword.

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        graph = dict(list())
        for word in wordList:
            for i in range(len(word)):
                s = word[0:i] + "*" + word[i+1:len(word)]
                
                if s not in graph:
                    graph[s] = []
                graph[s].append(word)
        
        queue = collections.deque()
        queue.append((beginWord, 1))
        
        visited = set()
        visited.add(beginWord)
        
        
        while len(queue) > 0:
            node, level = queue.popleft()
            
            
            for i in range(len(node)):
                s = node[0:i] + "*" + node[i+1:len(node)]
                if s in graph and graph[s] is not None:
                    for adj in graph[s]:
                        
                        if adj == endWord:
                            return level+1
                        
                        if adj not in visited:
                            visited.add(adj)
                            queue.append((adj, level+1))
                            
        return 0