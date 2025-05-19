from collections import defaultdict, deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """
        Approach:
        1. Preprocess the word list into wildcard pattern → words mapping.
        2. Perform BFS from beginWord to find the shortest path to endWord.
        """
        if endWord not in wordList:
            return 0

        # Step 1: Build pattern map
        pattern_map = defaultdict(list)
        wordList.append(beginWord)
        for word in wordList:
            for i in range(len(word)):
                pattern = word[:i] + '*' + word[i+1:]
                pattern_map[pattern].append(word)

        # Step 2: BFS
        queue = deque([(beginWord, 1)])  # (current_word, level)
        visited = set([beginWord])

        while queue:
            current_word, level = queue.popleft()

            for i in range(len(current_word)):
                pattern = current_word[:i] + '*' + current_word[i+1:]
                for neighbor in pattern_map[pattern]:
                    if neighbor == endWord:
                        return level + 1
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.append((neighbor, level + 1))

        return 0
