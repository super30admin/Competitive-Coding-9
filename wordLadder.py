# Time Complexity: O(n*l^2) n is the size of wordList and l is word length
# Space Complexity: O(n)
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0

        queue = deque()
        queue.append(beginWord)
        level = 1

        while queue:
            size = len(queue)
            for _ in range(size):
                word = queue.popleft()
                word_chars = list(word)

                for i in range(len(word_chars)):
                    original_char = word_chars[i]

                    for c in range(ord('a'), ord('z') + 1):
                        new_char = chr(c)
                        if new_char == original_char:
                            continue

                        word_chars[i] = new_char
                        new_word = ''.join(word_chars)

                        if new_word == endWord:
                            return level + 1

                        if new_word in wordSet:
                            queue.append(new_word)
                            wordSet.remove(new_word)

                    word_chars[i] = original_char  # restore

            level += 1

        return 0