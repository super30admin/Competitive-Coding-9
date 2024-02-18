'''

Time Complexity : O(nk)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Perform a BFS to identify the first set of elements which match the start word after single transition. Use a priority queue to maintain the
levels.

'''

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        words = set(wordList)
        q = collections.deque()
        q.append(beginWord)
        level = 0

        while q:
            level += 1

            for _ in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return level

                for i in range(len(word)):
                    for j in range(97,123):
                        if chr(j) == word[i]:
                            continue
                        else:
                            new = word[:i] + chr(j) + word[i+1:]

                        if new in words:
                            q.append(new)
                            words.remove(new)

        return 0
