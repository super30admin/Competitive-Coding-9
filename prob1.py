# Time Complexity : O(l*n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0
        
        queue = deque([(beginWord, 1)])
        
        while queue:
            word, steps = queue.popleft()
            if word == endWord:
                return steps
            
            for i in range(len(word)):
                for char in 'abcdefghijklmnopqrstuvwxyz':
                    next_word = word[:i] + char + word[i+1:]
                    if next_word in wordSet:
                        wordSet.remove(next_word)  # Mark as visited
                        queue.append((next_word, steps + 1))
        
        return 0
