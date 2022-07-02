'''
Time:
Space:
'''

from collections import defaultdict, deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if not endWord or not beginWord or not wordList or endWord not in wordList:
            return 0
        
        l = len(beginWord)
        d = defaultdict(list)

        for word in wordList:
            for i in range(l):
                temp = word[:i] + '*' + word[i+1:]
                d[temp].append(word)
        
        
        q = deque()
        q.append((beginWord,1))
        visited = dict()
        
        
        while len(q) != 0:
            cword, level = q.popleft()
            
            for i in range(l):
                bword = cword[:i] + '*' + cword[i+1:]
                for word in d[bword]:
                    if word == endWord:
                        return level + 1
                    
                    if word not in visited:
                        visited[word] = True
                        q.append((word, level+1))
        return 0
                    
                    
        
        