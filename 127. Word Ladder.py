'''
T - O(s^2*wordlist) for graph where s is len of string and substring function also takes s time so its s^2. The same would hold true for bfs 
S - O(s^2*wordlist) as we create intermediate string in graph and graph would hold all combinations of s and wordlist
Apprach - first graph is created for every string like grouping anagrams and then bfs is performed to reach endword

'''

from collections import defaultdict,deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        ladderMap = defaultdict(list)
        if endWord not in wordList:
            return 0
        for word in wordList:
            for w in range(len(word)):
                key = word[:w]+'*'+word[w+1:]
                ladderMap[key].append(word)
        size = 0
        Q = deque()
        Q.append([beginWord,1])
        visited = set()
        visited.add(beginWord)
        while len(Q) != 0:
            currWord,size = Q.popleft()
            for k in range(len(beginWord)):
                key= currWord[:k]+'*'+currWord[k+1:]
                for items in ladderMap[key]:
                    if items == endWord:
                        return size + 1
                    if items not in visited:
                        Q.append([items,size+1])
                        visited.add(items)
        return 0
                    
        