#Time Complexity : O(m^2 * n) where m is the average length of words and n is the number of words
#Space Complexity : O(m^2 * n) where m is the average length of words and n is the number of words
#Did this code successfully run on Leetcode : Yes

from collections import defaultdict, deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        d = defaultdict(list)
        #make a dictionary of all words which fall under a certain pattern in our wordList
        for word in wordList:
            for i in range(len(word)):
                d[word[: i] + '*' + word[i + 1: ]].append(word)

        level = 1
        visited = set()
        q = deque([beginWord])
       #perform a level order traversal to check how many word transformations we require to reach our endWord from out startword
        while q:
            for _ in range(len(q)):
                cur = q.popleft()
                if cur == endWord:
                    return level
                if cur in visited:
                    continue
                visited.add(cur)
                for i in range(len(cur)):
                    for word in d[cur[:i ] + '*' + cur[i + 1: ]]:
                        q.append(word)
                    del d[cur[:i ] + '*' + cur[i + 1: ]]
            level += 1

        return 0
