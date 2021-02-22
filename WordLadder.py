# Time Complexity : O(M^2 * N)
# Space Complexity : O(M^2 * N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Here we need to check how many connections we can make from BeginWord to EndWord in a graph. For eg hit can make *it, h*t, hi* and * can be any character from a to z
# Now we need to find the shortest distance between the BeginWord and EndWord so we will use BFS Approach
# So we initialize a queue with beginWord and level 1
# Until queue is not empty we will pop the node and level from the queue and check if node is endWord if it is then return level as we found the word
# If not we will iterate over the length of the node and try to check if we can form a word by replacing * by any character between a to z for each character in node
# And if the formed words are in Wordlist we append it to the queue with the level+1 as that is the next level
# After we append the word to queue we will remove that word from wordList

from collections import deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str,
                     wordList: List[str]) -> int:
        wordList = set(wordList)
        queue = deque()
        queue.append([beginWord, 1])
        while queue:
            node, level = queue.popleft()
            if node == endWord:
                return level
            for i in range(len(node)):
                for ch in 'abcdefghijklmnopqrstuvwxyz':
                    word = node[:i] + ch + node[i + 1:]
                    if word in wordList:
                        queue.append([word, level + 1])
                        wordList.remove(word)
        return 0
