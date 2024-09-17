# Time Complexity: O(M2N)
# Space Complexity: O(M2N)
from collections import defaultdict
from collections import deque


class Solution:
    def ladderLength(self, beginWord, endWord, wordList):

        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
        hmap = defaultdict(list)
        length = len(beginWord)

        for w in wordList:
            for i in range(length):
                curr = w[:i] + "#" + w[i + 1:]
                hmap[curr].append(w)

        q = deque([(beginWord, 1)])
        visited = set()
        visited.add(beginWord)

        while q:

            curr, level = q.popleft()

            for i in range(length):
                key = curr[:i] + "#" + curr[i + 1:]

                for w in hmap[key]:

                    if w == endWord:
                        return level + 1

                    if w not in visited:
                        visited.add(w)
                        q.append((w, level + 1))
        return 0