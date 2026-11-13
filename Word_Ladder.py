# Time Complexity : O(NL)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Here we need to check how many connections we can make from BeginWord to EndWord in a graph. For eg hit can make *it, h*t, hi* and * can be any character from a to z
# Now we need to find the shortest distance between the BeginWord and EndWord so we will use BFS Approach.
# We will first initialize the set for O(1) lookup since we need to check the set if the word is in set
# Also check if endword is in set if not return 0
# So we initialize a queue with beginWord
# Until queue is not empty we will pop the word from the queue and size of the queue for each level initailly set to 1
# Check if word is endWord if it is then return level as we found the word
# If not we will iterate over the length of the word and try to check if we can form a word by replacing * by any character between a to z for each character in node
# And if the formed words are in Wordlist we append it to the queue. After each level we will increase the level
# After we append the word to queue we will remove that word from set not to cause any repeats

from collections import deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list[str]) -> int:
        wordset = set(wordList)
        if endWord not in wordset:
            return 0
        queue = deque()
        queue.append(beginWord)
        level = 1
        while queue:
            size = len(queue)
            for i in range(size):
                word = queue.popleft()
                if word == endWord:
                    return level
                for i in range(len(word)): 
                    for ch in "abcdefghijklmnopqrstuvwxyz": 
                        new_word = word[:i] + ch + word[i+1:] 
                        if new_word in wordset:
                            queue.append(new_word)
                            wordset.remove(new_word)
            level += 1
        return 0


