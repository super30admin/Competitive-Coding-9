#Time Complexity : O(NK) where N is number of words and K is length of words
#Space Complexity :O(N) where N is number of words
from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set()
         
        for i in range(len(wordList)):
            wordSet.add(wordList[i])
            
        queue = deque([beginWord])
        level = 1
        
        while (len(queue) > 0):
            n = len(queue)
            for i in range(n):
                mainWord = queue.popleft()
            
                for i in range(len(mainWord)):
                    for j in range(26):
                        replacingchar = chr(ord('a') + j)
                        currWord = mainWord[:i] + replacingchar + mainWord[i+1:]
                    
                        if (currWord in wordSet):
                                queue.append(currWord)
                                wordSet.remove(currWord)
                            
                                if (currWord == endWord):
                                    return level + 1
            level += 1
                    
        return 0
            