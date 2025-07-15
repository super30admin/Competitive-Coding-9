"""
Build a graph where words are connected if they differ by one letter
Use BFS from beginWord to find the shortest path to endWord
Use wildcard patterns (e.g., h*t, *it) to optimize adjacency lookup
"""
"""
Time Complexity: O(N × L²) – N = #words, L = word length	
Space Complexity: O(N × L) – for pattern map and visited
"""

from collections import defaultdict, deque

class wordLadder:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list[str]) -> int:
        if endWord not in wordList:
            return 0

        wordList.append(beginWord)
        pattern_map = defaultdict(list)

        for word in wordList:
            for i in range(len(word)):
                pattern = word[:i] + '*' + word[i+1:]
                pattern_map[pattern].append(word)

        visited = set()
        queue = deque([(beginWord, 1)])

        while queue:
            word, level = queue.popleft()
            if word == endWord:
                return level

            for i in range(len(word)):
                pattern = word[:i] + '*' + word[i+1:]
                for neighbor in pattern_map[pattern]:
                    if neighbor not in visited:
                        visited.add(neighbor)
                        queue.append((neighbor, level + 1))

        return 0

if __name__ == "__main__":
    obj = wordLadder()
    print(obj.ladderLength("hit", "cog", ["hot","dot","dog","lot","log","cog"]))  # Output: 5
