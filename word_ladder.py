
# Time Complexity : O(m**m*n) where m is the length of the word and n is number of words
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I create all variations of the word and add the word to it. I then do BFS on the word list and all the variations of the current word as they are
# at a distance of 1. At each level I increment the distance. When I find the endWord, I return the distance.

from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        curr = beginWord
        q = deque()
        s = set()
        distance = 1
        q.append(curr)  
        mapping = defaultdict(lambda: [])
        
        for word in wordList:
            word_length = len(word)
            for i in range(word_length):
                w = word[:i]+"*"+word[i+1:]
                mapping[w].append(word)
        
        while len(q) > 0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                s.add(curr)
                word_length = len(curr)
                for i in range(word_length):
                    w = curr[:i]+"*"+curr[i+1:]
                    adjacent = mapping[w]
                    for word in adjacent:
                        if word == endWord:
                            return distance + 1
                        if word not in s:
                            s.add(word)
                            q.append(word)
            distance += 1
        return 0
