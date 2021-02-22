from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        #Approach: BFS, level-order traversal
        #Time Complexity: O(m * n^2)
        #Space Complexity: O(m)
        #where, m is the length of wordList
        #and, n is the length of given words
        
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        
        de = deque()
        de.append(beginWord)
        wordList.discard(beginWord)
        
        level = 1
        while de:
            sz = len(de)
            for _ in range(sz):
                popped = de.popleft()
                if popped == endWord:
                    return level
                
                for i in range(len(popped)):
                    for j in range(26):
                        char = chr(ord('a') + j)
                        newWord = popped[:i] + char + popped[i+1:]
                        
                        if newWord in wordList:
                            de.append(newWord)
                            wordList.remove(newWord)
                            
            level += 1
        
        return 0