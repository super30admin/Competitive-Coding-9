# Time Complexity : O(N * L * 26) where N = number of words, L = word length
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use BFS for shortest path in word transformation graph.
# Start from beginWord and explore all possible one-letter transformations.
# For each position, replace with 'a' to 'z' to generate new words.
# If the new word exists in the word set, add it to the queue and remove
# it from the set to avoid revisiting.
# Continue level by level; when endWord is reached, return the step count.
# If not reachable, return 0.


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque()
        q.append((beginWord,1))
        word_set = set(wordList)
        while q:
            word,step = q.popleft()
            if word == endWord:
                return step
            for i in range(len(word)):
                for j in "abcdefghijklmnopqrstuvwxyz":
                    new_word = word[:i] + j + word[i + 1:]

                    if new_word in word_set:
                        word_set.remove(new_word)
                        q.append((new_word,step + 1))
        
        return 0
