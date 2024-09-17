'''
    Time Complexity:
        O(260n) (where n = length of the wordList)
        (Since beginWod can be at most 10 characters long, it can generate 260 possible neighbors)

    Space Complexity:
        O(260n) (where n = length of the wordList)
        (Since beginWod can be at most 10 characters long, it can generate 260 possible neighbors

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking and BFS.
        Maintain a set of given wordList for quicker search.

        Start the BFS traversal with beginWord.
        Process all the nodes at a level to keep track of which level you're at.

        Generate all possible neighbors of a given word (by changing each character individually).
        If the given neighbor is in the word set:
            Remove it from the word set.
            Add it to the queue as the given word's child.

'''

a, z = ord('a'), ord('z')

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        word_set = set(wordList)

        q = collections.deque()
        q.append(beginWord)
        level = 0

        while q:
            size = len(q)
            level += 1

            for _ in range(size):
                word_obj = Word(q.popleft())
                if word_obj.word == endWord:
                    return level

                for neighbor in word_obj.neighbors():
                    if neighbor in word_set:
                        word_set.remove(neighbor)
                        q.append(neighbor)
        return 0

class Word:
    def __init__(self, word):
        self.word = word
        self._w = list(word)

    def neighbors(self):
        for i, char in enumerate(self._w):
            for c in range(a, z+1):
                self._w[i] = chr(c)
                yield ''.join(self._w)

            self._w[i] = char
