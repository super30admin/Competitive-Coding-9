from collections import defaultdict
from collections import deque


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        start = beginWord
        end = endWord
        words = wordList
        if (end not in words) or (not words) or len(start) != len(end):
            return 0
        worddict = defaultdict(list)
        l = len(start)
        for w in words:
            for i in range(l):
                worddict[w[:i]+'*'+w[i+1:]].append(w)
        q = deque([(start, 1)])
        visited = set()
        visited.add(start)
        while q:
            curr, time = q.popleft()
            for i in range(l):
                temp = curr[:i]+"*"+curr[i+1:]
                for w in worddict[temp]:
                    if w == end:
                        return time+1
                    if w not in visited:
                        visited.add(w)
                        q.append([w, time+1])
                worddict[temp] = []
        return 0
