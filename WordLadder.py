# Time Complexity : O(N * L * 26) where N = number of words in wordList, L = word length, and 26 = alphabet letters.
# Space Complexity : O(N) for the queue and set used in BFS.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We start from beginWord and use BFS to explore one-letter transformations at each level.
# If a transformed word equals endWord, we return the level + 1 as the shortest path.
# We use a set to track valid unvisited words and remove them once added to the queue.

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)

        if endWord not in wordSet:
            return 0

        q = deque([(beginWord, 1)])
        visited = set([beginWord])

        while q:
            word, steps = q.popleft()

            if word == endWord:
                return steps

            for i in range(len(word)):
                for c in range(26):
                    ch = chr(ord('a') + c)
                    newWord = word[:i] + ch + word[i+1:]

                    if newWord in wordSet and newWord not in visited:
                        q.append((newWord, steps + 1))
                        visited.add(newWord)

        return 0


        