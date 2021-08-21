# Approach 
"""
TC: O(n)
SC: O(n)
"""

from collections import defaultdict, deque
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        mapping = defaultdict(list)
        visited = set()
        q = deque()
        for word in wordList: # O(n)
            for i in range(len(word)): #O(m)
                mapping[word[:i] + '#' + word[i+1:]].append(word) #O(m)
        q.append([beginWord, 1])
        visited.add(beginWord)

        while q:
            curr_word, count = q.popleft()
            for char in range(len(curr_word)): #O(m)
                inter_word = curr_word[:char] + '#' + curr_word[char + 1:] #O(m)
                for parent_word in mapping[inter_word]:
                    if parent_word == endWord:
                        return count + 1
                    else:
                        if parent_word not in visited:
                            visited.add(parent_word)
                            q.append((parent_word, count + 1))
        return 0