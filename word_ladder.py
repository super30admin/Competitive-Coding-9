# -*- coding: utf-8 -*-
"""
TC:O(N*M^2) where M is length of the individual word and N is number of words in the given list
SC:O(N*M^2) where M is length of the individual word and N is number of words in the given list
"""

from collections import deque, defaultdict
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        graph = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                key = word[:i] + '_' + word[i+1:]
                graph[key].append(word)
                
        visited = set()
        q = deque([(beginWord, 1)])
        while q:
            word, distance = q.popleft()
            
            if word == endWord:
                return distance
            
            if word in visited:
                continue
            visited.add(word)
            
            
            for i in range(len(word)):
                key = word[:i] + '_' + word[i+1:]
                for neighbor in graph[key]:
                    q.append((neighbor, distance+1))
        return 0