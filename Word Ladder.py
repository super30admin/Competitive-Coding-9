class Solution:
    # Time O(m**2 * n)
    # Space O(N)
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # BFS APPROACH
        dq = deque()
        dq.append((beginWord, 1))
        hset = set(wordList)

        while dq:
            curr, level = dq.popleft()
            if curr == endWord:
                return level
            for i in range(len(curr)):
                for j in range(ord('a'), ord('z') + 1):
                    word = curr[:i] + chr(j) + curr[i + 1:]
                    if word in hset:
                        dq.append((word, level + 1))
                        hset.remove(word)
        return 0