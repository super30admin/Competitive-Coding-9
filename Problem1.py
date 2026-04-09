# https://leetcode.com/problems/word-ladder/description/

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:

        if endWord not in wordList:
            return 0

        hm = defaultdict(list)

        for word in wordList:
            for i in range(len(word)):
                pattern = word[0:i] + "*" + word[i+1:len(word)]
                hm[pattern].append(word)

        q = deque()
        q.append(beginWord)
        visited = set([beginWord])
        res = 1
        while q:
            for i in range(len(q)):
                word = q.popleft()
                if word == endWord:
                    return res
                for j in range(len(word)):
                    pattern = word[0:j] + "*" + word[j+1:len(word)]
                    for neiword in hm[pattern]:
                        if neiword not in visited:
                            visited.add(neiword)
                            q.append(neiword)

            res += 1
        return 0