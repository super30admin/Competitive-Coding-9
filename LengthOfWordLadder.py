# Time Complexity : O(nxl), where n is the number of words in the list and l is the length of each word in the list
# Space Complexity : O(n+l)

from collections import deque
from typing import List

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not beginWord or not endWord or not wordList:
            return 0
        
        # Create a set of words for quick lookup
        wordSet = set(wordList)
        # If the endWord is not in wordList, return 0
        if endWord not in wordSet:
            return 0

        # Create a queue for BFS and add the beginWord into it
        queue = deque([beginWord])
        # Initialize level to 0
        level = 0

        # While the queue is not empty
        while queue:
            size = len(queue)
            # For each word in the current level
            for _ in range(size):
                currentWord = queue.popleft()
                # If the current word equals the endWord, return level + 1
                if currentWord == endWord:
                    return level + 1
                wordChars = list(currentWord)
                # Change each character of the current word
                for j in range(len(wordChars)):
                    originalChar = wordChars[j]
                    # Try all possible lowercase letters
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        wordChars[j] = c
                        newWord = ''.join(wordChars)
                        # If the new word is in the wordSet, add it to the queue and remove it from the wordSet
                        if newWord in wordSet:
                            queue.append(newWord)
                            wordSet.remove(newWord)
                    # Restore the original character
                    wordChars[j] = originalChar
            # Increase the level by 1
            level += 1
        # If there is no valid transformation sequence, return 0
        return 0

# Examples

# Example 1
beginWord = "hit"
endWord = "cog"
wordList = ["hot", "dot", "dog", "lot", "log", "cog"]

solution = Solution()
print(solution.ladderLength(beginWord, endWord, wordList))  # Output: 5

# Example 2
beginWord = "hit"
endWord = "cog"
wordList = ["hot", "dot", "dog", "lot", "log"]

solution = Solution()
print(solution.ladderLength(beginWord, endWord, wordList))  # Output: 0

# Example 3
beginWord = "a"
endWord = "c"
wordList = ["a", "b", "c"]

solution = Solution()
print(solution.ladderLength(beginWord, endWord, wordList))  # Output: 2