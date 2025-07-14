#Time Complexity: O(N * L)
#Space Complexity: O(N * L)

from collections import deque
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        wordSet = set(wordList)  
        if endWord not in wordSet:
            return 0

        queue = deque()
        queue.append((beginWord, 1))  

        while queue:
            current_word, length = queue.popleft()
            
            for i in range(len(current_word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    new_word = current_word[:i] + c + current_word[i+1:]
                    
                    if new_word == endWord:
                        return length + 1

                    if new_word in wordSet:
                        wordSet.remove(new_word)  
                        queue.append((new_word, length + 1))
        return 0  
            
            