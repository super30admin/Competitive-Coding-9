"""
Rasika Sasturkar
Time Complexity: O(n*m^2), n is no. of words in wordList of avg. length m
Space Complexity: O(n*m^2)
"""

import collections


def ladderLength(beginWord: str, endWord: str, wordList) -> int:
    if endWord not in wordList:
        return 0

    # creating adjacency list
    wordmap = collections.defaultdict(list)

    for word in wordList:
        for j in range(len(word)):
            pattern = word[:j] + "*" + word[j + 1:]
            wordmap[pattern].append(word)

    # Using BFS
    count = 0
    queue = collections.deque([beginWord])
    visited = set()
    visited.add(beginWord)
    count += 1

    while queue:
        size = len(queue)
        for i in range(size):
            curr = queue.popleft()
            if curr == endWord:
                return count
            for j in range(len(curr)):
                pattern = curr[:j] + "*" + curr[j + 1:]
                for neighbor in wordmap[pattern]:
                    if neighbor not in visited:
                        queue.append(neighbor)
                        visited.add(neighbor)
        count += 1
    return 0


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(ladderLength(beginWord="hit", endWord="cog", wordList=["hot"
        , "dot", "dog", "lot", "log", "cog"]))  # return 5
    print(ladderLength(beginWord="hit", endWord="cog", wordList=["hot"
        , "dot", "dog", "lot", "log"]))  # return 0


if __name__ == "__main__":
    main()
