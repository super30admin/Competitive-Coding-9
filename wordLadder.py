# Time Complexity : O(n*l), where l is the average length of the words
# Space Complexity : O(n), where n is the number of words in wordList
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Your code here along with comments explaining your approach

# This approach uses a BFS to arrive at the final word from the start word. The methodology
# is to try all possible permutations of the word by changing one letter at a time.
# If the changed word exists in the given list, it is added for further exploration.
from collections import deque
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        # Edge case, null pointers or if endWord not present
        if not beginWord or not endWord or not wordList or endWord not in wordList:
            return 0

        result = 1
        wordSet = set(wordList)
        # BFS using a queue
        q = deque()
        q.append(beginWord)

        while q:
            size = len(q)
            # For every word in the queue
            for _ in range(size):
                currWord = q.popleft()
                # For every letter in every word
                for i in range(len(currWord)):
                    # replace with every possible letter
                    for j in range(26):
                        repl = chr(ord('a') + j)
                        newWord = currWord[:i] + repl + currWord[i + 1:]
                        # if destination
                        if newWord == endWord:
                            return result + 1
                        # if path found
                        if newWord in wordSet:
                            q.append(newWord)
                            wordSet.remove(newWord)

            result += 1

        return 0
