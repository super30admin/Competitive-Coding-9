#Problem1:https://leetcode.com/problems/word-ladder/description/
# Time Complexity: O(N * L * 26)
# N is number of words in wordList, L is length of each word.
# For every word we pop from the queue, we check all L positions and at each position we try all 26 letters, so each word costs O(L * 26).
# In the worst case every word in wordList gets processed once, giving O(N * L * 26).

# Space Complexity: O(N)
# The set holds up to N words and the queue can hold up to N words at once.
# char_word and new_word are O(L) but do not scale with N so they do not change the bound.

# Approach:
# This is shortest path in an unweighted graph, so we use BFS.
# Each word is a node, and two words are connected if they differ by one letter.
# We start from beginWord and expand outward one letter change at a time.
# We track how many words deep we are using level.
# The moment a change produces endWord, level + 1 is the answer.
# A set is used for O(1) lookups and removals so we never revisit a used word.

from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        set_words = set(wordList)  # convert list to set for O(1) lookup and removal

        if endWord not in set_words:  # if endWord is not even in the dictionary, no path is possible
            return 0
        
        queue = deque()  # deque gives O(1) pop from the front, needed for BFS
        queue.append(beginWord)  # start BFS from beginWord
        level = 1  # beginWord counts as the first word in the sequence

        while queue:  # keep going while there are words left to expand
            size = len(queue)  # freeze how many words belong to this level before we add new ones

            for i in range(size):  # process exactly this many words, all from the current level
                curr_word = queue.popleft()  # take the next word from the front of the queue
                char_word = list(curr_word)  # convert to list since strings cannot be modified in place

                for j in range(len(char_word)):  # try changing each letter position one at a time
                    original = char_word[j]  # remember the real letter so we can restore it later

                    for c in range(ord("a"), ord("z") + 1):  # try every letter a to z at this position
                        if char_word[j] == chr(c):  # skip if it is the same letter, that is not a real change
                            continue
                        
                        char_word[j] = chr(c)  # place the new letter at position j
                        new_word = ''.join(char_word)  # rebuild the full word as a string

                        if new_word == endWord:  # found the target word
                            return level + 1  # answer is one more than the current level

                        if new_word in set_words:  # valid word we have not used yet
                            queue.append(new_word)  # add it to be expanded in the next level
                            set_words.remove(new_word)  # remove so it cannot be reused or revisited

                    char_word[j] = original  # restore original letter before moving to next position

            level += 1  # entire current level is processed, move to next level

        return 0  # queue emptied without reaching endWord, no valid sequence exists
        