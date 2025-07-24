# ----------------------------------------------------
# LeetCode 127. Word Ladder
#
# Intuition:
# - We want the shortest transformation sequence from `beginWord` to `endWord`,
#   where each step changes only one letter and must be in the word list.
# - This is a classic shortest path problem in an unweighted graph, where:
#   - Each word is a node.
#   - Two nodes are connected if they differ by exactly one character.
# - BFS guarantees the shortest path when traversing such a graph.
#
# Approaches:
#
# 1) **Bidirectional BFS (Optimal)**:
#    - Use two frontiers: one starting from `beginWord`, the other from `endWord`.
#    - Always expand the smaller frontier to reduce the search space.
#    - This reduces time complexity drastically in practice.
#    - Time: O(N * L * 26), where:
#        N = number of words,
#        L = length of each word,
#        26 = possible letter replacements per position.
#    - Space: O(N).
#
# 2) **Standard BFS**:
#    - Use a queue and expand from `beginWord` step by step until `endWord` is found.
#    - Slower compared to bidirectional BFS as it explores in one direction only.
#    - Time: O(N * L * 26), Space: O(N).
# ----------------------------------------------------

from collections import deque
from typing import List


class Solution:

    # ----------------------------------------------------
    # 1. Bidirectional BFS
    # ----------------------------------------------------
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0

        # Initialize frontiers from both sides
        begin_set = {beginWord}
        end_set = {endWord}
        visited = {beginWord, endWord}
        word_len = len(beginWord)
        ladder = 1

        while begin_set and end_set:
            # Always expand the smaller frontier
            if len(begin_set) > len(end_set):
                begin_set, end_set = end_set, begin_set

            next_level = set()

            for word in begin_set:
                for i in range(word_len):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        new_word = word[:i] + c + word[i+1:]

                        if new_word in end_set:
                            return ladder + 1

                        if new_word in word_set and new_word not in visited:
                            visited.add(new_word)
                            next_level.add(new_word)

            begin_set = next_level
            ladder += 1

        return 0

    # ----------------------------------------------------
    # 2. Standard BFS
    # ----------------------------------------------------
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0

        visited = {beginWord}
        queue = deque([(beginWord, 1)])  # (word, current ladder length)

        while queue:
            word, level = queue.popleft()

            if word == endWord:
                return level

            for i in range(len(word)):
                for ch in "abcdefghijklmnopqrstuvwxyz":
                    new_word = word[:i] + ch + word[i+1:]
                    if new_word in word_set and new_word not in visited:
                        visited.add(new_word)
                        queue.append((new_word, level + 1))

        return 0


# ----------------------------------------------------
# Example Usage
# ----------------------------------------------------
if __name__ == "__main__":
    sol = Solution()
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]

    print(sol.ladderLength(beginWord, endWord, wordList))  # 5

