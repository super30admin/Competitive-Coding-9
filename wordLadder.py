class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        # T: O(m * n), S: O(n)
        wordSet = set(wordList)  # Convert to set for O(1) lookups
        if endWord not in wordSet:
            return 0

        queue = deque([(beginWord, 1)])  # (word, level)

        while queue:
            word, level = queue.popleft()
            if word == endWord:
                return level

            # Try changing each letter in the word
            for i in range(len(word)):
                for c in "abcdefghijklmnopqrstuvwxyz":
                    newWord = word[:i] + c + word[i + 1 :]
                    if newWord in wordSet:
                        queue.append((newWord, level + 1))
                        wordSet.remove(newWord)  # Mark as visited

        return 0  # No transformation sequence found
